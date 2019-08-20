package pl.writeonly.re.shared.hyde.impl.oo.oo1

import pl.writeonly.re.shared.hyde.common.states.oo._
import pl.writeonly.re.shared.hyde.common.url._
import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.common.url.urls.Urls
import pl.writeonly.re.shared.hyde.sourcepage.SourcePage
import pl.writeonly.re.shared.hyde.sourcepage.oo.SourcePageFromInternalUrl

class StandardExceptionState(urls: Urls)(implicit d: Domain) extends AbstractOOState(urls) {

  override def map: InternalUrl => SourcePage = SourcePageFromInternalUrl.apply

  override def nextState(urls: Urls): AbstractOOState = new StandardExceptionState(urls)
}

object StandardExceptionState extends AbstractOOStateObject {

  override def fromDomain(implicit d: Domain): AbstractOOState = new StandardExceptionState(Urls.fromDomain)
}
