package energy.data

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by soltar on 30/07/2017.
  */
class SensorDataLoaderTest extends FlatSpec with Matchers {
  "A CSV loader" should "load data from file and skip invalid records" in {
    val sensorData = new CSVDataLoader().load().toList
    sensorData should have size 72
  }

}
