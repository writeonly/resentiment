package pl.writeonly.re.shared.hyde.sourcepage

import scala.concurrent.Future

import pl.writeonly.re.shared.hyde.common.url.exception.UrlException

package object std {
  type SourcePageEither = Either[UrlException, SourcePage]

  type SourcePageEitherSet = Set[SourcePageEither]

  type SourcePageFuture = Future[SourcePageEither]

}
