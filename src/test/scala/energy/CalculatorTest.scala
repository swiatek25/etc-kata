package energy

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by soltar on 30/07/2017.
  */
class CalculatorTest extends FlatSpec with Matchers {
  "calculator" should "return consumption for sensor" in {
    val consumption = Calculator.consumption("b08c6195-8cd9-43ab-b94d-e0b887dd73d2")

    consumption.daily() should equal(10.713)
    consumption.averageHourly(0, 7) should equal(0.322875)
    consumption.averageHourly(8, 15) should equal(0.44925)
    consumption.averageHourly(16, 23) should equal(0.567)
  }

  "calculator" should "return no consumption for missing sensor" in {
    val consumption = Calculator.consumption("wrong")

    consumption.daily() should equal(0)
    consumption.averageHourly(0, 20) should equal(0)
  }

  "calculator" should "return no consumption for wrong range" in {
    val consumption = Calculator.consumption("b08c6195-8cd9-43ab-b94d-e0b887dd73d2")

    consumption.averageHourly(20, 17) should equal(0)

  }

}
