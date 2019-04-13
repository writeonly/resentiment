package pl.writeonly.re.shared.calculator

import fastparse.core.Parsed
import utest._

@SuppressWarnings(Array("org.wartremover.warts.Any"))
object CalculatorParserTest extends TestSuite {
  override val tests: Tests = Tests {

    val parser = new CalculatorParser()
    val expr = parser.expr
    "2+3" - {
      val result = expr.parse("2+3")
      val Expected = 2 + 3
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
    "2-3" - {
      val result = expr.parse("2-3")
      val Expected = 2 - 3
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
    "2*3" - {
      val result = expr.parse("2*3")
      val Expected = 2 * 3
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
    "2/3" - {
      val result = expr.parse("2/3")
      val Expected = 2 / 3
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
    "1+1*" - {
      val result = expr.parse("1+1*")
      assertMatch(result) {
        case _: Parsed.Failure[_, _] =>
      }
    }
    "(1+1*2)+3*4" - {
      val result = expr.parse("(1+1*2)+3*4")
      val Expected = (1 + 1 * 2) + 3 * 4
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
    "((1+1*2)+3*4*5)/3" - {
      val result = expr.parse("((1+1*2)+3*4*5)/3")
      val Expected = ((1 + 1 * 2) + 3 * 4 * 5) / 3
      assertMatch(result) {
        case Parsed.Success(Expected, _) =>
      }
    }
  }
}
