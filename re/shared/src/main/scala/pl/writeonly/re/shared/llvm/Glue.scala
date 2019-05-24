package pl.writeonly.re.shared.llvm

import scalaz.Scalaz._
import slogging.StrictLogging

class Glue extends StrictLogging {
  private val Limit = 5000

  def apply(): Unit = {
    val levels = List("0", "1", "2", "3", "fast", "g", "s", "z")

    val path = "../lua-llvm/O"
    val tables = levels
      .map(path + _)
      .map(AggregateTable.apply)

    "ALL DATAS" |> info
    tables
      .map(_.show)
      .foreach(info)

    "FILTRED DATAS" |> info
    tables
      .map(_.showWithLimit(Limit))
      .foreach(info)
  }

  private def info(message: String): Unit = logger.info(message)
}
