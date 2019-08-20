package pl.writeonly.re.main

import pl.writeonly.re.shared.core._
import pl.writeonly.re.shared.hyde.impl.Hyde
import slogging._
import slogging.TerminalLoggerFactory.TerminalControlCode

object Main extends App {
  LoggerConfig.factory = TerminalLoggerFactory()
  TerminalLoggerFactory.infoCode = TerminalControlCode.green
  TerminalLoggerFactory.debugCode = TerminalControlCode.cyan
  TerminalLoggerFactory.traceCode = TerminalControlCode.blue

  LoggerConfig.level = LogLevel.TRACE
  Core.apply("Native")

  StrictLoggingCore.rainbow()

  Hyde.main(args)
}
