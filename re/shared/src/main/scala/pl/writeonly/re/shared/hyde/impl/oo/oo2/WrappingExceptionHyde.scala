package pl.writeonly.re.shared.hyde.impl.oo.oo2

import pl.writeonly.re.shared.hyde.common.states.oo.AbstractOOState

object WrappingExceptionHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit = apply().showResult()

  def apply(): AbstractOOState = WrappingExceptionState(domain)
}
