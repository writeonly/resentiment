package pl.writeonly.re.shared.llvm

import scalaz.Scalaz._
import slogging.StrictLogging

class Glue extends StrictLogging {

  def info(message: String): Unit = logger.info(message)

  def apply(): Unit = {
    val levels = List("0", "1", "2", "3", "fast", "g", "s", "z")


    val path = "../lua-llvm/O"
    levels
      .map(path + _)
      .map(AggregateTable.apply)
      .foreach(a => {
        logger.info(a.dirName)
        a.aggregates.foreach(s => logger.info(s.toString))
      })

    levels
      .map(path + _)
      .map(AggregateTable.apply)
      .foreach(a => {
        a.dirName |> info
        a.aggregates.filter(10000 <= _.count).map(_.toString).foreach(info)
      })
  }
}
