package pl.writeonly.re.shared.hyde.common.url.urls

import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrls

case class UrlsWithThrowableList(urls: Urls, throwableList: ThrowableList) {

  def next(newUrls: NewUrls, newThrowableList: ThrowableList): UrlsWithThrowableList =
    new UrlsWithThrowableList(urls.next(newUrls), throwableList ++ newThrowableList)

  def showStep(): Unit = {
    urls.showStep()
    Urls.showPart(details = false, "throwableList", throwableList)
  }

  def showResult(): Unit = {
    urls.showResult()
    Urls.showPart(details = true, "throwableList", throwableList)
  }

  def isEmptyNextInternalUrls: Boolean = urls.isEmptyNextInternalUrls

  def nextUrls: InternalUrls = urls.nextUrls
}

object UrlsWithThrowableList {
  def fromDomain(implicit d: Domain): UrlsWithThrowableList =
    new UrlsWithThrowableList(Urls.fromDomain, List.empty)
}
