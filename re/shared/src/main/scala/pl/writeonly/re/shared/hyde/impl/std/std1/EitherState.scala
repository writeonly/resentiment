package pl.writeonly.re.shared.hyde.impl.std.std1

import pl.writeonly.re.shared.hyde.common.states.api.EitherAPIState
import pl.writeonly.re.shared.hyde.common.states.notexception._
import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.urls.UrlsWithThrowableList
import pl.writeonly.re.shared.hyde.sourcepage.std.SourcePageEitherFromInternalUrl

class EitherState(data: UrlsWithThrowableList)(implicit d: Domain) extends EitherAPIState(data) with AbstractFunctionState {

  override def impureFunction: HPFromInternalUrl = SourcePageEitherFromInternalUrl.apply

  override def nextState(data: UrlsWithThrowableList): AbstractNextState = new EitherState(data)
}

object EitherState extends AbstractNextStateObject {

  override def fromDomain(implicit d: Domain): AbstractNextState = new EitherState(UrlsWithThrowableList.fromDomain)
}
