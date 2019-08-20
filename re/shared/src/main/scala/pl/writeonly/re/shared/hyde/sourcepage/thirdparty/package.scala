package pl.writeonly.re.shared.hyde.sourcepage

import pl.writeonly.re.shared.hyde.common.url.exception.UrlException
import scalaz.Disjunction
import scalaz.concurrent.Task

package object thirdparty {
  type SourcePageDisjunction = Disjunction[UrlException, SourcePage]

  type SourcePageDisjunctionSet = Set[SourcePageDisjunction]

  type SourcePageTask = Task[SourcePageDisjunction]

}
