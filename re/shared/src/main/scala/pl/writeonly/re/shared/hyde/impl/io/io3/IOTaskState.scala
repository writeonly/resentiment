package pl.writeonly.re.shared.hyde.impl.io.io3

import pl.writeonly.re.shared.hyde.common.states.api._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.io.SourcePageIOIOFromInternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty._
import scalaz.ioeffect.Task

class IOTaskState(data: UrlsWithThrowableList)(implicit d: Domain) extends DisjunctionAPIState(data) {

  override type NextState = IOTaskState

  def nextState(data: UrlsWithThrowableList): IOTaskState = new IOTaskState(data)

  def nextMonad: Task[IOTaskState] = {

    val set: Set[Task[SourcePageDisjunction]] = data.nextUrls
      .map(SourcePageIOIOFromInternalUrl.apply)
    val monad: Task[SourcePageDisjunctionSet] = IOTaskState.traverse(set)

    monad.map(newState)
  }
}

object IOTaskState {

  def fromDomain(implicit d: Domain): IOTaskState = new IOTaskState(UrlsWithThrowableList.fromDomain)

  def run(state: IOTaskState): ParallelStateIOTask =
    if (state.isEmptyNextInternalUrls) Task.now(state) else state.nextMonad.flatMap(run)

  private def traverse(set: Set[Task[SourcePageDisjunction]]): Task[SourcePageDisjunctionSet] =
    set.foldLeft(Task.point[SourcePageDisjunctionSet](Set.empty)) { (b: Task[SourcePageDisjunctionSet], a: Task[SourcePageDisjunction]) =>
      b.flatMap(bb => a.map(aa => bb + aa))
    }
}
