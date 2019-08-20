package pl.writeonly.re.shared.hyde.impl.oo.oo3

import pl.writeonly.re.shared.hyde.common.states.api._
import pl.writeonly.re.shared.hyde.common.states.notexception._
import pl.writeonly.re.shared.hyde.common.url._
import pl.writeonly.re.shared.hyde.common.url.typed._
import pl.writeonly.re.shared.hyde.common.url.urls._
import pl.writeonly.re.shared.hyde.sourcepage.oo._

class TryState(data: UrlsWithThrowableList)(implicit d: Domain) extends AbstractAPIState(data) with AbstractFunctionState {

  override type HP = SourcePageTry

  def nextData(set: SourcePageTrySet): UrlsWithThrowableList = {

    val partitioned = set.partition(_.isSuccess)

    val newWrappedUrls: WrappedUrlSet = partitioned._1
      .flatMap(TryState.sourcePageTryToWrappedUrlSet)

    val newThrowableList: ThrowableList = partitioned._2.toList
      .flatMap(_.failed.toOption.toList)

    val newUrls = NewUrls(newWrappedUrls)

    data.next(newUrls, newThrowableList)
  }

  override def impureFunction: InternalUrl => HP = SourcePageTryFromInternalUrl.apply

  override def nextState(data: UrlsWithThrowableList): AbstractNextState = new TryState(data)
}

object TryState extends AbstractNextStateObject {

  val sourcePageTryToWrappedUrlSet: SourcePageTry => WrappedUrlSet = _.map(_.getWrappedUrlSet).toOption.toSet.flatten

  override def fromDomain(implicit d: Domain): AbstractNextState = new TryState(UrlsWithThrowableList.fromDomain)
}
