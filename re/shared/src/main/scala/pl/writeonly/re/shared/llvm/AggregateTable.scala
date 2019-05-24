package pl.writeonly.re.shared.llvm

import scalaz.Scalaz._

case class AggregateTable(dirName: String, aggregates: List[Aggregate]) {
  def show: String =
    showHead + Separator + aggregates.map(_.show).mkString(Separator)

  def showWithLimit(limit: Int): String =
    showHead + Separator + aggregates
      .filter(limit <= _.count)
      .map(_.show)
      .mkString(Separator)

  private def showHead: String =
    dirName + Separator + aggregates.length.toString
}

object AggregateTable {
  def apply(dirName: String): AggregateTable =
    AggregateTable(
      dirName,
      dirName |> Dir.linesFromDir |> Aggregate.aggregateFromLines
    )
}
