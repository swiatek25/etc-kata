package energy.data

import java.time.ZonedDateTime

import scala.util.Try

/**
  * Created by soltar on 30/07/2017.
  */
case class SensorData(sensorId: String, date: ZonedDateTime, consumption: Double)

object SensorData {
  private[data] def apply(id: String, timestamp: String, consumption: String): Try[SensorData] = {
    Try {
      SensorData(id, ZonedDateTime.parse(timestamp), consumption.toDouble)
    }
  }
}
