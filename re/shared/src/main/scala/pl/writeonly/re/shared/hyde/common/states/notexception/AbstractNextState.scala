package pl.writeonly.re.shared.hyde.common.states.notexception

import scala.annotation.tailrec

import pl.writeonly.re.shared.hyde.common.states.api.AbstractAPIState
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList

trait AbstractNextState extends AbstractAPIState {

  type NextState = AbstractNextState

  def next: NextState

  def nextState(data: UrlsWithThrowableList): AbstractNextState
}

object AbstractNextState {
  @tailrec
  def run(state: AbstractNextState): AbstractNextState = if (state.isEmptyNextInternalUrls) state else run(state.next)
}
