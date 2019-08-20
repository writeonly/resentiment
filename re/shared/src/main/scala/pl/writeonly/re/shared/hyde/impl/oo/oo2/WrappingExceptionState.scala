package pl.writeonly.re.shared.hyde.impl.oo.oo2

import pl.writeonly.re.shared.hyde.common.states.oo._
import pl.writeonly.re.shared.hyde.common.url._
import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.common.url.urls.Urls
import pl.writeonly.re.shared.hyde.sourcepage.SourcePage
import pl.writeonly.re.shared.hyde.sourcepage.oo.SourcePageOrThrowExceptionFromInternalUrl

class WrappingExceptionState(urls: Urls)(implicit d: Domain) extends AbstractOOState(urls) {

  override def map: InternalUrl => SourcePage = SourcePageOrThrowExceptionFromInternalUrl.apply

  override def nextState(urls: Urls): AbstractOOState = new WrappingExceptionState(urls)
}

object WrappingExceptionState extends AbstractOOStateObject {

  override def fromDomain(implicit d: Domain): AbstractOOState = new WrappingExceptionState(Urls.fromDomain)
}
