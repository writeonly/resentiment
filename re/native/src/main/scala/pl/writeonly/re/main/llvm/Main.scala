package pl.writeonly.re.main.llvm

import pl.writeonly.re.shared.llvm._
import slogging._

object Main extends App with StrictLogging {
  LoggerConfig.factory = PrintLoggerFactory()
  LoggerConfig.level = LogLevel.DEBUG

  new Glue().apply()
}
