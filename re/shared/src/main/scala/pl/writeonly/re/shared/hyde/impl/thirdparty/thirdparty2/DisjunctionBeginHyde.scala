package pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty2

import pl.writeonly.re.shared.hyde.common.states.notexception.AbstractNextState

object DisjunctionBeginHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit = apply().showResult()

  def apply(): AbstractNextState = DisjunctionBeginState(domain)

}
