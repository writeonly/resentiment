package pl.writeonly.re.shared.hyde.sourcepage.thirdparty

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.oo.SourcePageFromInternalUrl
import scalaz.Disjunction
import scalaz.Scalaz._

object SourcePageDisjunctionFromInternalUrl extends (InternalUrl => SourcePageDisjunction) {

  override def apply(internalUrl: InternalUrl): SourcePageDisjunction =
    Disjunction.attempt(internalUrl |> SourcePageFromInternalUrl.apply)(internalUrl.toException)

}
