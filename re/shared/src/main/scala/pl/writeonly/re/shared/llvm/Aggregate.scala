package pl.writeonly.re.shared.llvm

import scala.math.Ordered.orderingToOrdered

import scalaz.Scalaz._

case class Aggregate(name: Token, count: Int) extends Ordered[Aggregate] {

  def compare(that: Aggregate): Int =
    (that.count, this.name).compare((this.count, that.name))
}

object Aggregate {

  def aggregate(it: List[Token]): List[Aggregate] =
    it.groupBy(identity)
      .mapValues(_.size)
      .toList
      .map((Aggregate.apply _).tupled)
      .sorted

  def aggregateFromLines(lines: List[String]): List[Aggregate] =
    lines |> Token.parseLines2 |> Aggregate.aggregate
}
