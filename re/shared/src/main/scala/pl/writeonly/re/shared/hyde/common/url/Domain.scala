package pl.writeonly.re.shared.hyde.common.url

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl

class Domain(domain: WrappedUrl) {

  def this(url: String) = this(new WrappedUrl(url))

  println("domain " + toString)

  override def toString: String = domain.toString

  def toInternalUrl: InternalUrl = InternalUrl(domain)(this)

  def toInternalUrl(url: WrappedUrl): InternalUrl = new InternalUrl(domain.append(url))

  def isInternalUrl(url: WrappedUrl): Boolean = url.isInternalUrl(domain)

  def toWrappedUrl: WrappedUrl = domain
}
