package energy

import energy.data.{SensorData, SensorDataProvider}

/**
  * Created by soltar on 30/07/2017.
  */
object Calculator extends SensorDataProvider {

  type SensorId = String

  def consumption(sensorId: SensorId, unit: Units.PowerUnit = Units.kWh): PowerConsumption =
    new PowerConsumption(get().filter(_.sensorId == sensorId), unit)

}

object Units {
  type PowerUnit = Double => Double

  object kWh extends PowerUnit {
    override def apply(v1: Double): Double = v1 / 1000
  }

  object Wh extends PowerUnit {
    override def apply(v1: Double): Double = v1
  }

}

class PowerConsumption(data: Stream[SensorData], unit: Units.PowerUnit) {
  def daily(): Double = unit(data.map(_.consumption).sum)

  def averageHourly(startHour: Int, endHour: Int): Double = {
    val hourConsumption = data.filter(hoursIn(startHour to endHour)).map(_.consumption)
    hourConsumption match {
      case Stream.Empty => 0
      case consumption => unit(consumption.sum / consumption.length)
    }
  }

  private def hoursIn(hourRange: Range)(data: SensorData) = hourRange.contains(data.date.getHour)
}
