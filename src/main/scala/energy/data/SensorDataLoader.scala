package energy.data

import scala.io.Source

trait SensorDataProvider {
  protected def loader: DataLoader = new CSVDataLoader()

  protected final def get(): Stream[SensorData] = loader.load()
}

trait DataLoader {
  def load(): Stream[SensorData]
}

private[data] class CSVDataLoader(separator: Char = ',', encoding: String = "UTF-8") extends DataLoader {
  def dataFile = "/consumption_data.csv"

  override def load(): Stream[SensorData] = {
    val dataResource = getClass.getResource(dataFile).toURI
    Source.fromFile(dataResource, encoding).getLines()
      .drop(1) //skip header
      .map(_.split(separator))
      .map {
        case Array(id, timestamp, value) => SensorData(id, timestamp, value).toOption
      }.toStream.flatten //skip invalid entries. could be something more elaborate like logging warn or returning empty iterator
  }
}
