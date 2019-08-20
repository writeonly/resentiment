package pl.writeonly.re.main

import pl.writeonly.re.shared.core.Core
import pl.writeonly.re.shared.hyde.impl.Hyde
import slogging._

object Main extends App {
  LoggerConfig.factory = SLF4JLoggerFactory()

  LoggerConfig.level = LogLevel.TRACE
  Core.apply("JVM")

  Hyde.main(args)
}
