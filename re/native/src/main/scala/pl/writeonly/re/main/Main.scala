package pl.writeonly.re.main

import pl.writeonly.re.shared.core.Core
import slogging._

object Main extends App {
  LoggerConfig.factory = PrintLoggerFactory()
  LoggerConfig.level = LogLevel.DEBUG
  Core.apply("Native")
}
