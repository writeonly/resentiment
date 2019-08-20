package pl.writeonly.re.shared.hyde.impl.io.io2

import pl.writeonly.re.shared.hyde.common.states.api._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.io.SourcePageIOIOFromInternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty._
import scalaz.ioeffect.IO

class IOIOState(data: UrlsWithThrowableList)(implicit d: Domain) extends DisjunctionAPIState(data) {

  override type NextState = IOIOState

  def nextState(data: UrlsWithThrowableList): IOIOState = new IOIOState(data)

  def nextMonad: IO[Throwable, IOIOState] = {

    val set: Set[IO[Throwable, SourcePageDisjunction]] = data.nextUrls
      .map(SourcePageIOIOFromInternalUrl.apply)
    val monad: IO[Throwable, SourcePageDisjunctionSet] = IOIOState.traverse(set)

    monad.map(newState)
  }
}

object IOIOState {

  def fromDomain(implicit d: Domain): IOIOState = new IOIOState(UrlsWithThrowableList.fromDomain)

  def run(state: IOIOState): ParallelStateIOIO =
    if (state.isEmptyNextInternalUrls) IO.now(state) else state.nextMonad.flatMap(run)

  private def traverse(set: Set[IO[Throwable, SourcePageDisjunction]]): IO[Throwable, SourcePageDisjunctionSet] =
    set.foldLeft(IO.point[Throwable, SourcePageDisjunctionSet](Set.empty)) {
      (b: IO[Throwable, SourcePageDisjunctionSet], a: IO[Throwable, SourcePageDisjunction]) =>
        b.flatMap(bb => a.map(aa => bb + aa))
    }
}
