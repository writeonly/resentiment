package pl.writeonly.re.shared

import utest._
import scalaz.Scalaz._

object CalculatorTest extends TestSuite {
  override val tests: Tests = Tests {
    val calculator = new Calculator()
    'addition - {
      val addition: (Int, Int) => Int = (x, y) => calculator.add(x, y)
      "0 + 0 == 0" - {
        assert(addition(0, 0) === 0)
      }
      "2 + 2 == 4" - {
        assert(addition(2, 2) === 4)
      }
    }
    'multiplication - {
      val multiplication: (Int, Int) => Int = (x, y) => calculator.mul(x, y)
      "0 + 0 == 0" - {
        assert(multiplication(0, 0) === 0)
      }
      "2 + 2 == 4" - {
        assert(multiplication(2, 2) === 4)
      }
    }
    'less_or_equal - {
      val less_or_equal: (Int, Int) => Boolean = (x, y) => calculator.leq(x, y)
      "0 <= 2 == true" - {
        assert(less_or_equal(0, 2))
      }
      "2 <= 0 == false" - {
        assert(!less_or_equal(2, 0))
      }
    }
  }
}
