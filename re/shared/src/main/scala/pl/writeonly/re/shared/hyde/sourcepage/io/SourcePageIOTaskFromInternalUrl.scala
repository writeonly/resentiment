package pl.writeonly.re.shared.hyde.sourcepage.io

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.thirdparty.SourcePageDisjunctionFromInternalUrl
import scalaz.Scalaz._
import scalaz.ioeffect.Task

object SourcePageIOTaskFromInternalUrl {

  def apply(internalUrl: InternalUrl): SourcePageIOTask =
    Task(internalUrl |> SourcePageDisjunctionFromInternalUrl.apply)
}
