package pl.writeonly.re.shared.hyde.impl.std.std4

import scala.concurrent._

import pl.writeonly.re.shared.hyde.common.states.api._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.std._
import scalaz.Scalaz._

class FutureState(data: UrlsWithThrowableList)(implicit d: Domain, ec: ExecutionContext) extends EitherAPIState(data) {

  override type NextState = FutureState

  override def nextState(data: UrlsWithThrowableList): FutureState = new FutureState(data)

  def nextMonad: Future[FutureState] = {

    val set: Set[Future[SourcePageEither]] = nextUrls
      .map(SourcePageFutureFromInternalUrl.apply)

    val monad: Future[SourcePageEitherSet] = Future
      .sequence(set)

    monad.map(newState)
  }

}

object FutureState {

  def apply(domain: String)(implicit ec: ExecutionContext): ParallelStateFuture = fromDomain(new Domain(domain)) |> run

  def fromDomain(domain: Domain)(implicit ec: ExecutionContext): FutureState = fromDomainAllImplicit(domain, ec)

  private def fromDomainAllImplicit(implicit d: Domain, ec: ExecutionContext): FutureState =
    new FutureState(UrlsWithThrowableList.fromDomain)

  def run(state: FutureState)(implicit executor: ExecutionContext): Future[EitherAPIState] =
    if (state.isEmptyNextInternalUrls) Future.successful(state) else state.nextMonad.flatMap(run)
}
