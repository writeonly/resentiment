package pl.writeonly.re.shared.hyde.impl.std.std2

import scala.concurrent._
import scala.concurrent.duration._

import pl.writeonly.re.shared.hyde.common.states.api.EitherAPIState
import pl.writeonly.re.shared.hyde.common.states.notexception._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.std._
import scalaz.Scalaz._

class EitherBeginState(data: UrlsWithThrowableList)(implicit d: Domain, ec: ExecutionContext) extends EitherAPIState(data) with AbstractNewSetState {

  override def newSet: SourcePageEitherSet = {

    val set: Set[Future[SourcePageEither]] = nextUrls
      .map(SourcePageFutureFromInternalUrl.apply)

    val future: Future[SourcePageEitherSet] = Future.sequence(set)

    Await.result(future, 1.minute)
  }

  override def nextState(data: UrlsWithThrowableList): AbstractNextState = new EitherBeginState(data)
}

object EitherBeginState {

  def apply(domain: String)(implicit ec: ExecutionContext): AbstractNextState = fromDomain(new Domain(domain)) |> AbstractNextState.run

  def fromDomain(domain: Domain)(implicit ec: ExecutionContext): AbstractNextState = fromDomainAllImplicit(domain, ec)

  private def fromDomainAllImplicit(implicit d: Domain, ec: ExecutionContext): AbstractNextState =
    new EitherBeginState(UrlsWithThrowableList.fromDomain)

}
