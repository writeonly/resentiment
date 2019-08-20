package pl.writeonly.re.shared.hyde.sourcepage

import scala.util.matching.Regex

import pl.writeonly.re.shared.hyde.common.url._
import pl.writeonly.re.shared.hyde.common.url.WrappedUrl
import scalaz.Scalaz._

final case class SourcePage(sourcePage: String) {

  def getWrappedUrlSet: WrappedUrlSet = getWrappedUrlSet(SourcePage.HUrlRegex1) ++ getWrappedUrlSet(SourcePage.HUrlRegex2)

  private def getWrappedUrlSet(regex: Regex): WrappedUrlSet = iterator(regex).toSet

  private def iterator(regex: Regex): Iterator[WrappedUrl] = for { m <- regex.findAllMatchIn(sourcePage) } yield m.group(1) |> WrappedUrl.apply
}

object SourcePage {
  private val HUrlRegex1: Regex = """href='([^']*)'""".r
  private val HUrlRegex2: Regex = """href="([^"]*)"""".r
}
