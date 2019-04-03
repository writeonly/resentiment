package pl.writeonly.re.shared.calculator

import fastparse.core.Parsed
import utest._

@SuppressWarnings(Array("org.wartremover.warts.Any"))
object CalculatorParserTest extends TestSuite {
  override val tests: Tests = Tests {
    val parser = new CalculatorParser()
    val expr = parser.expr
    "1+1" - {
      val result = expr.parse("1+1")

      assertMatch(result) {
        case Parsed.Success(2, _) =>
      }
    }
    "1+1*" - {
      val result = expr.parse("1+1*")

      assertMatch(result) {
        case _: Parsed.Failure[_, _] =>
      }
    }
  }
}
