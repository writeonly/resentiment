package pl.writeonly.re.shared.hyde.impl.oo.oo3

import pl.writeonly.re.shared.hyde.common.states.notexception.AbstractNextState

object TryHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit = apply().showResult()

  def apply(): AbstractNextState = TryState(domain)
}
