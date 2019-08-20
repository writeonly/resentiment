package pl.writeonly.re.shared.hyde.sourcepage.io

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty.SourcePageDisjunctionFromInternalUrl
import scalaz.Scalaz._
import scalaz.ioeffect.IO

object SourcePageIOIOFromInternalUrl {

  def apply(internalUrl: InternalUrl): SourcePageIOIO =
    IO.sync(internalUrl |> SourcePageDisjunctionFromInternalUrl.apply)
}
