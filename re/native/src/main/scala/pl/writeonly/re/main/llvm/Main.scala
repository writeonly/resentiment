package pl.writeonly.re.main.llvm

import pl.writeonly.re.shared.llvm._
import slogging._
import slogging.TerminalLoggerFactory.TerminalControlCode

object Main extends App with StrictLogging {
  LoggerConfig.factory = TerminalLoggerFactory()
  TerminalLoggerFactory.infoCode = TerminalControlCode.green
  TerminalLoggerFactory.debugCode = TerminalControlCode.cyan
  TerminalLoggerFactory.traceCode = TerminalControlCode.blue

  LoggerConfig.level = LogLevel.TRACE

  new Glue().apply()
}
