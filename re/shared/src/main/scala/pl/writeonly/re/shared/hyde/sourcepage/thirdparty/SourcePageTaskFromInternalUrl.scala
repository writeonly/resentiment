package pl.writeonly.re.shared.hyde.sourcepage.thirdparty

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import scalaz.Scalaz._
import scalaz.concurrent.Task

object SourcePageTaskFromInternalUrl {

  def apply(internalUrl: InternalUrl): SourcePageTask =
    Task(internalUrl |> SourcePageDisjunctionFromInternalUrl.apply)
}
