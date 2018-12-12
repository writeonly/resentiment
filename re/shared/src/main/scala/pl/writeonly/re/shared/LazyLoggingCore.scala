package pl.writeonly.re.shared

import slogging.LazyLogging

object LazyLoggingCore extends Core with LazyLogging {
  def apply(arg: String): Unit = {
    logger.info(s"Hello Scala $arg!")
  }
}
