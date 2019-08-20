package pl.writeonly.re.shared.hyde.sourcepage.oo

import scala.io.Source

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl
import pl.writeonly.re.shared.hyde.sourcepage.SourcePage
import scalaz.Scalaz._

object SourcePageFromInternalUrl extends (InternalUrl => SourcePage) {

  def apply(internalUrl: InternalUrl): SourcePage = Source.fromURL(internalUrl.toURL).mkString |> SourcePage.apply
}
