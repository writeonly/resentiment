package pl.writeonly.re.shared.hyde.sourcepage.oo

import java.io.IOException
import java.net.URISyntaxException

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.SourcePage

object SourcePageOrThrowExceptionFromInternalUrl extends (InternalUrl => SourcePage) {

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  override def apply(internalUrl: InternalUrl): SourcePage =
    try {
      SourcePageFromInternalUrl(internalUrl)
    } catch {
      case e: RuntimeException   => throw internalUrl.toException(e)
      case e: IOException        => throw internalUrl.toException(e)
      case e: URISyntaxException => throw internalUrl.toException(e)
    }
}
