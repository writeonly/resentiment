package pl.writeonly.re.shared.hyde.sourcepage.io

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty.SourcePageDisjunctionFromInternalUrl
import scalaz.Scalaz._
import scalaz.effect.IO

object SourcePageIOFromInternalUrl {

  def apply(internalUrl: InternalUrl): SourcePageIO =
    IO(internalUrl |> SourcePageDisjunctionFromInternalUrl.apply)
}
