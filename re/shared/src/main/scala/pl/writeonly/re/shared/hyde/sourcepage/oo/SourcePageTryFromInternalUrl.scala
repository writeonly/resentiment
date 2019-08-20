package pl.writeonly.re.shared.hyde.sourcepage.oo

import scala.util.Try

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage._
import scalaz.Scalaz._

object SourcePageTryFromInternalUrl extends (InternalUrl => SourcePageTry) {

  def apply(internalUrl: InternalUrl): Try[SourcePage] = Try(internalUrl |> SourcePageFromInternalUrl.apply)
}
