package pl.writeonly.re.shared.llvm.regex

import scalaz.Scalaz._

case class Instruction(token: String) extends Ordered[Instruction] {

  def compare(that: Instruction): Int = this.token compare that.token

  def show: String = token
}

object Instruction {
  private val r = """^  (%\d+ = )?(\w+).*$""".r

  def parseLines(xs: List[String]): List[Instruction] = xs
    .map(parseLine)
    .flatMap(_.toList)

  private[regex] def parseLine(input: String): Option[Instruction] = input match {
    case r(_, token) => token |> (Instruction(_)) |> Option.apply
    case _           => Option.empty[Instruction]
  }
}
