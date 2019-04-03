package pl.writeonly.re.shared.core

import slogging.LazyLogging

object LazyLoggingCore extends Core with LazyLogging {
  def apply(arg: String): Unit = {
    logger.info(s"Hello Scala $arg!")
  }
}
