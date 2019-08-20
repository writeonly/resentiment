package pl.writeonly.re.shared.hyde.common.url.urls

import scala.collection.immutable._

import pl.writeonly.re.shared.hyde.common.url.Domain
import pl.writeonly.re.shared.hyde.common.url.typed._

class Urls(count: Int, val externalUrls: ExternalUrls, val internalUrls: InternalUrls, val nextUrls: InternalUrls) {

  def next(newUrls: NewUrls): Urls =
    new Urls(
      count + 1,
      externalUrls ++ newUrls.newExternalUrls,
      internalUrls ++ nextUrls,
      SortedSet(newUrls.newInternalUrls.filter(isNewInternalUrl).toSeq: _*)
    )

  def showStep(): Unit = {
    Urls.showHeader("count: " + count.toString)
    Urls.showPart(details = false, "externalUrls", externalUrls)
    Urls.showPart(details = false, "internalUrls", internalUrls)
    Urls.showPart(details = false, "nextUrls", nextUrls)
    nextUrls.foreach(Urls.showString)
  }

  def showResult(): Unit = {
    Urls.showPart(details = true, "externalUrls", externalUrls)
    Urls.showPart(details = true, "internalUrls", internalUrls)
    Urls.showPart(details = true, "nextUrls", nextUrls)
  }

  private def isNewInternalUrl(internalUrl: InternalUrl): Boolean =
    !internalUrls.contains(internalUrl) && !nextUrls.contains(internalUrl)

  def isEmptyNextInternalUrls: Boolean = nextUrls.isEmpty
}

object Urls {

  def showPart(details: Boolean, x: String, xs: Iterable[AnyRef]): Unit = {
    showHeader(x + " size: " + xs.size.toString)
    if (details) xs.foreach(showString)
  }

  private def showHeader(x: String): Unit = {
    (1 to 80).foreach(_ => print("'"))
    println("")
    println(x)
  }

  private def showString(x: AnyRef): Unit = println(x)

  def fromDomain(implicit d: Domain): Urls =
    new Urls(0, SortedSet.empty, SortedSet.empty, SortedSet(d.toInternalUrl))
}
