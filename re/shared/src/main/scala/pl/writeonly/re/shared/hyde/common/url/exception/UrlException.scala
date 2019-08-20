package pl.writeonly.re.shared.hyde.common.url.exception

class UrlException(url: String, e: Throwable) extends IllegalArgumentException(url, e)
