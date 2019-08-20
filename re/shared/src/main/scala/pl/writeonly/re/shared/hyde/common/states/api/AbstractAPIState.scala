package pl.writeonly.re.shared.hyde.common.states.api

import pl.writeonly.re.shared.hyde.common.states.State
import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrls
import pl.writeonly.re.shared.hyde.common.url.urls._
import scalaz.Scalaz._

abstract class AbstractAPIState(data: UrlsWithThrowableList) extends State {

  type HP

  final type SET = Set[HP]

  type NextState

  override def showStep(): Unit = data.showStep()

  def showResult(): Unit = data.showResult()

  def isEmptyNextInternalUrls: Boolean = data.isEmptyNextInternalUrls

  override def toString: String = data.toString

  final def newState(set: SET): NextState = set |> nextData |> nextState

  def nextData(set: SET): UrlsWithThrowableList

  def nextState(data: UrlsWithThrowableList): NextState

  protected def nextUrls: InternalUrls = data.nextUrls

  def throwableList: ThrowableList = data.throwableList

}
