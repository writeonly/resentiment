package pl.writeonly.re.shared.core

import slogging.StrictLogging

object StrictLoggingCore extends Core with StrictLogging {
  def apply(arg: String): Unit = {
    logger.info(s"Hello Scala $arg!")
  }

  def rainbow(): Unit = {
    logger.error("rainbow error")
    logger.warn("rainbow warn")
    logger.info("rainbow info")
    logger.debug("rainbow debug")
    logger.trace("rainbow trace")
  }
}
