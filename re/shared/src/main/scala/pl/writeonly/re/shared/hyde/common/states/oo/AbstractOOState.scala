package pl.writeonly.re.shared.hyde.common.states.oo

import scala.annotation.tailrec

import pl.writeonly.re.shared.hyde.common.states.State
import pl.writeonly.re.shared.hyde.common.url._
import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.common.url.urls._
import pl.writeonly.re.shared.hyde.sourcepage.SourcePage
import scalaz.Scalaz._

abstract class AbstractOOState(urls: Urls)(implicit d: Domain) extends State {

  override final def showResult(): Unit = urls.showResult()

  override final def showStep(): Unit = urls.showStep()

  override final def isEmptyNextInternalUrls: Boolean = urls.isEmptyNextInternalUrls

  final def next: AbstractOOState = getWrappedUrlSet |> NewUrls.apply |> urls.next |> nextState

  final def getWrappedUrlSet: WrappedUrlSet =
    urls.nextUrls
      .map(map)
      .flatMap(_.getWrappedUrlSet)

  def nextState(urls: Urls): AbstractOOState

  def map: InternalUrl => SourcePage

}

object AbstractOOState {
  @tailrec
  def run(state: AbstractOOState): AbstractOOState = if (state.isEmptyNextInternalUrls) state else run(state.next)
}
