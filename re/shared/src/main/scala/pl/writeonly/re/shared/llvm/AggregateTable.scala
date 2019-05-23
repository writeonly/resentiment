package pl.writeonly.re.shared.llvm

import scalaz.Scalaz._

case class AggregateTable(dirName: String, aggregates: List[Aggregate])

object AggregateTable {
  def apply(dirName: String): AggregateTable =
    AggregateTable(
      dirName,
      dirName |> Dir.linesFromDir |> Aggregate.aggregateFromLines
    )
}
