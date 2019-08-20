package pl.writeonly.re.shared.hyde.common.states

trait State {
  def showResult(): Unit

  def showStep(): Unit

  def isEmptyNextInternalUrls: Boolean
}
