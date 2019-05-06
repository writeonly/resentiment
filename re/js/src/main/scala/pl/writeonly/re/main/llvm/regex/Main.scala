package pl.writeonly.re.main.llvm.regex

import pl.writeonly.re.shared.llvm.regex.Glue
import slogging._

object Main extends App with StrictLogging {
  LoggerConfig.factory = PrintLoggerFactory()
  LoggerConfig.level = LogLevel.DEBUG

  new Glue().apply()
}
