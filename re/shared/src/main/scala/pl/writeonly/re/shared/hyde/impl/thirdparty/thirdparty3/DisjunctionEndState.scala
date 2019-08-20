package pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty3

import pl.writeonly.re.shared.hyde.common.states.api.DisjunctionAPIState
import pl.writeonly.re.shared.hyde.common.states.notexception.AbstractNextState
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty._
import scalaz.Scalaz._
import scalaz.concurrent.Task

class DisjunctionEndState(data: UrlsWithThrowableList)(implicit d: Domain) extends DisjunctionAPIState(data) with AbstractNextState {

  override def next: AbstractNextState = {

    val set: Set[Task[SourcePageDisjunction]] = nextUrls
      .map(SourcePageTaskFromInternalUrl.apply)

    val monad: Task[SourcePageDisjunctionSet] = Task.gatherUnordered(set.toSeq).map(_.toSet)

    monad.map(newState).unsafePerformSync
  }

  override def nextState(data: UrlsWithThrowableList): AbstractNextState = new DisjunctionEndState(data)
}

object DisjunctionEndState {

  def apply(domain: String): AbstractNextState = fromDomain(new Domain(domain)) |> AbstractNextState.run

  def fromDomain(implicit d: Domain): AbstractNextState =
    new DisjunctionEndState(UrlsWithThrowableList.fromDomain)
}
