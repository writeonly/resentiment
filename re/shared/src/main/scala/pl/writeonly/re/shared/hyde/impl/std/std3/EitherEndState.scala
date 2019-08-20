package pl.writeonly.re.shared.hyde.impl.std.std3

import scala.concurrent._
import scala.concurrent.duration._

import pl.writeonly.re.shared.hyde.common.states.api.EitherAPIState
import pl.writeonly.re.shared.hyde.common.states.notexception._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.std._
import scalaz.Scalaz._

class EitherEndState(data: UrlsWithThrowableList)(implicit d: Domain, ec: ExecutionContext) extends EitherAPIState(data) with AbstractNextState {

  override def next: AbstractNextState = {

    val set: Set[Future[SourcePageEither]] = nextUrls
      .map(SourcePageFutureFromInternalUrl.apply)

    val monad: Future[SourcePageEitherSet] = Future.sequence(set)

    Await.result(monad.map(newState), 1.minute)
  }

  override def nextState(data: UrlsWithThrowableList): AbstractNextState = new EitherEndState(data)
}

object EitherEndState {

  def apply(domain: String)(implicit ec: ExecutionContext): AbstractNextState = fromDomain(new Domain(domain)) |> AbstractNextState.run

  def fromDomain(domain: Domain)(implicit ec: ExecutionContext): AbstractNextState = fromDomainAllImplicit(domain, ec)

  private def fromDomainAllImplicit(implicit d: Domain, ec: ExecutionContext): AbstractNextState =
    new EitherEndState(UrlsWithThrowableList.fromDomain)
}
