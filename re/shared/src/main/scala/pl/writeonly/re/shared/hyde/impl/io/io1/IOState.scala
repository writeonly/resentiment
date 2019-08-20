package pl.writeonly.re.shared.hyde.impl.io.io1

import pl.writeonly.re.shared.hyde.common.states.api.DisjunctionAPIState
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.io.SourcePageIOFromInternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty._
import scalaz.effect.IO

class IOState(data: UrlsWithThrowableList)(implicit d: Domain) extends DisjunctionAPIState(data) {

  override type NextState = IOState

  def nextState(data: UrlsWithThrowableList): IOState = new IOState(data)

  def nextMonad: IO[IOState] = {

    val set: Set[IO[SourcePageDisjunction]] = data.nextUrls
      .map(SourcePageIOFromInternalUrl.apply)
    val monad: IO[SourcePageDisjunctionSet] = IOState.traverse(set)

    monad.map(newState)
  }

}

object IOState {

  def fromDomain(implicit d: Domain): IOState = new IOState(UrlsWithThrowableList.fromDomain)

  def run(state: IOState): IO[DisjunctionAPIState] =
    if (state.isEmptyNextInternalUrls) IO.apply(state) else state.nextMonad.flatMap(run)

  private def traverse(set: Set[IO[SourcePageDisjunction]]): IO[SourcePageDisjunctionSet] = set.foldLeft(IO.apply(Set.empty[SourcePageDisjunction])) { (b, a) =>
    for {
      bb <- b
      aa <- a
    } yield bb + aa
  }

}
