package pl.writeonly.re.shared

import slogging.StrictLogging

object StrictLoggingCore extends Core with StrictLogging {
  def apply(arg: String): Unit = {
    logger.info(s"Hello Scala $arg!")
  }
}
