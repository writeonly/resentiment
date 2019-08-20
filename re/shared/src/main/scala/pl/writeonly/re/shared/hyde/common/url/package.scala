package pl.writeonly.re.shared.hyde.common

import scala.collection.immutable.SortedSet

package object url {
  type WrappedUrls = SortedSet[WrappedUrl]

  type WrappedUrlSet = Set[WrappedUrl]
}
