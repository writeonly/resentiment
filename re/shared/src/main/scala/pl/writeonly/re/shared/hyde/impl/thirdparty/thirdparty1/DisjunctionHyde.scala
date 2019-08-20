package pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty1

import pl.writeonly.re.shared.hyde.common.states.notexception.AbstractNextState

object DisjunctionHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit =
    apply().showResult()

  def apply(): AbstractNextState = DisjunctionState(domain)
}
