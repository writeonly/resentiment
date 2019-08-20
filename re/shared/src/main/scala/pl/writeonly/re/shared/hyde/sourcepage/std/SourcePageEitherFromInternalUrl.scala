package pl.writeonly.re.shared.hyde.sourcepage.std

import scala.util.control.Exception.nonFatalCatch

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.oo.SourcePageFromInternalUrl
import scalaz.Scalaz._

object SourcePageEitherFromInternalUrl extends (InternalUrl => SourcePageEither) {

  override def apply(internalUrl: InternalUrl): SourcePageEither =
    (nonFatalCatch either (internalUrl |> SourcePageFromInternalUrl.apply)).left.map(internalUrl.toException)
}
