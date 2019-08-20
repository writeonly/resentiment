package pl.writeonly.re.shared.optparse.applicative

import optparse_applicative._
import scalaz.Scalaz._

object SampleMain {

  val sample: Parser[Sample] =
    ^(
      strOption(
        long("hello"),
        metavar("TARGET"),
        help("Target for the greeting")
      ),
      switch(long("quiet"), help("Whether to be quiet"))
    )(Sample.apply)

  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  def greet(s: Sample): Unit = s match {
    case Sample(h, false) => println("Hello, " ++ h)
    case _                =>
  }

  def main(args: Array[String]): Unit = {
    val opts = info(
      sample <*> helper,
      progDesc("Print a greeting for TARGET"),
      header("hello - a test for scala-optparse-applicative")
    )
    greet(execParser(args, "SampleMain", opts))
  }

}
