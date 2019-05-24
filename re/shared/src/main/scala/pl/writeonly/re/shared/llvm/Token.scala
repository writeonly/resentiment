package pl.writeonly.re.shared.llvm

import scalaz.Scalaz._

case class Token(token: String) extends Ordered[Token] {

  def compare(that: Token): Int = this.token compare that.token

  def show: String = token

}

object Token {
  private val r = """^  (%\d+ = )?(\w+).*$""".r

  def parseLine(input: String): Option[Token] = input match {
    case r(_, token) => token |> (Token(_)) |> Option.apply
    case _           => Option.empty[Token]
  }

  def parseLines(it: List[String]): List[Option[Token]] = it.map(parseLine)

  def parseLines2(it: List[String]): List[Token] =
    (it |> parseLines) flatMap (_.toList)
}
