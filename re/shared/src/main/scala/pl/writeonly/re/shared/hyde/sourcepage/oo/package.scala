package pl.writeonly.re.shared.hyde.sourcepage

import scala.util.Try

package object oo {
  type SourcePageTry = Try[SourcePage]

  type SourcePageTrySet = Set[SourcePageTry]
}
