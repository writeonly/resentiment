package pl.writeonly.re.main

import scala.scalajs.js.annotation._

//import pl.writeonly.re.shared.core.Core
//import slogging._

//object Main extends App {
//  LoggerConfig.factory = PrintLoggerFactory()
//  LoggerConfig.level = LogLevel.DEBUG
//  Core.apply("JS")
//}

@JSExportTopLevel("main")
object Main {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  @JSExport
  def main(args: Array[String]): Unit = {
//    LoggerConfig.factory = PrintLoggerFactory()
//    LoggerConfig.level = LogLevel.DEBUG
//    Core.apply("JS")
  }
}

