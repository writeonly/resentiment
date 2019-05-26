package pl.writeonly.re.shared.llvm.regex

import scala.math.Ordered.orderingToOrdered

import scalaz.Scalaz._

case class Aggregate(name: Instruction, count: Int) extends Ordered[Aggregate] {

  def compare(that: Aggregate): Int =
    (that.count, this.name).compare((this.count, that.name))

  def show: String = "(" + name.show + Separator + count.toString + ")"
}

object Aggregate {

  def aggregate(it: List[Instruction]): List[Aggregate] =
    it.groupBy(identity)
      .mapValues(_.size)
      .toList
      .map((Aggregate.apply _).tupled)
      .sorted

  def aggregateFromLines(lines: List[String]): List[Aggregate] =
    lines |> Instruction.parseLines |> Aggregate.aggregate
}
