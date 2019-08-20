package pl.writeonly.re.shared.hyde.sourcepage.std

import scala.concurrent._

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import scalaz.Scalaz._

object SourcePageFutureFromInternalUrl {

  def apply(internalUrl: InternalUrl)(implicit executor: ExecutionContext): SourcePageFuture =
    Future(internalUrl |> SourcePageEitherFromInternalUrl.apply)
}
