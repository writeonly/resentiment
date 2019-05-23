package pl.writeonly.re.shared.llvm

//import scalaz.Scalaz._
import slogging.StrictLogging

class Glue extends StrictLogging {
  def apply(): Unit = {
    val levels = List("0", "1", "2", "3", "fast", "g", "s", "z")

    val path = "../lua-llvm/O"
    levels
      .map(path + _)
      .map(Dir.linesFromDir)
      .map(Aggregate.aggregateFromLines)
      .foreach(_.map(_.toString()).foreach(s => logger.info(s)))


//    levels
//      .map(path + _)
//      .map(AggregateTable.apply)
//      .foreach(a => {
//        logger.info(a.dirName)
//        a.aggregates.foreach(s => logger.info(s.toString))
//      })

//    val aggregates = path |> Dir.linesFromDir |> Aggregate.aggregateFromLines
//
//    aggregates
//      .map(_.toString)
//      .foreach(s => logger.info(s))
  }
}
