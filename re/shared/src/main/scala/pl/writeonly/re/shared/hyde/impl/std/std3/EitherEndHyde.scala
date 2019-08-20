package pl.writeonly.re.shared.hyde.impl.std.std3

import scala.concurrent.ExecutionContext.Implicits.global

import pl.writeonly.re.shared.hyde.common.states.notexception.AbstractNextState

object EitherEndHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit = apply().showResult()

  def apply(): AbstractNextState = EitherEndState(domain)

}
