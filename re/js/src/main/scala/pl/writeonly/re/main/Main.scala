package pl.writeonly.re.main

import pl.writeonly.re.shared.core.Core
import slogging._

object Main extends JSApp {
  override def main(): Unit = {
    LoggerConfig.factory = ConsoleLoggerFactory()

    LoggerConfig.level = LogLevel.TRACE
    Core.apply("JS")
  }
}
