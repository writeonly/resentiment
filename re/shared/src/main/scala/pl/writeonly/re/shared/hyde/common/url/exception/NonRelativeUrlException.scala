package pl.writeonly.re.shared.hyde.common.url.exception

class NonRelativeUrlException(url: String) extends IllegalArgumentException(url)
