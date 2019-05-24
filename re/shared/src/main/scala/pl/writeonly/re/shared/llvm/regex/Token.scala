package pl.writeonly.re.shared.llvm.regex

import scalaz.Scalaz._

case class Token(token: String) extends Ordered[Token] {

  def compare(that: Token): Int = this.token compare that.token

  def show: String = token
}

object Token {
  private val r = """^  (%\d+ = )?(\w+).*$""".r

  def parseLines(xs: List[String]): List[Token] = xs
    .map(parseLine)
    .flatMap(_.toList)

  private def parseLine(input: String): Option[Token] = input match {
    case r(_, token) => token |> (Token(_)) |> Option.apply
    case _           => Option.empty[Token]
  }

}
