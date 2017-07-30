package energy.data

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by soltar on 30/07/2017.
  */
class SensorDataTest extends FlatSpec with Matchers {
  "apply method" should "fail for invalid timestamp value" in {
    SensorData("anything", "wrong timestamp", "123").isFailure should be(true)
  }

  "apply method" should "fail for invalid consumption data value" in {
    SensorData("anything", "2017-03-30T00:00:00Z", "wrong value").isFailure should be(true)
  }

}
