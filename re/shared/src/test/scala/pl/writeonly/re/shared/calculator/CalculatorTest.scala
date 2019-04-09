package pl.writeonly.re.shared.calculator

import utest._

object CalculatorTest extends TestSuite {
  override val tests: Tests = Tests {
    val calculator = new Calculator()
    'addition - {
      val addition: (Int, Int) => Int = (x, y) => calculator.add(x, y)
      "0 + 0 == 0" - {
        addition(0, 0) ==> 0
      }
      "2 + 2 == 4" - {
        addition(2, 2) ==> 4
      }
    }
    'multiplication - {
      val multiplication: (Int, Int) => Int = (x, y) => calculator.mul(x, y)
      "0 + 0 == 0" - {
        multiplication(0, 0) ==> 0
      }
      "2 + 2 == 4" - {
        multiplication(2, 2) ==> 4
      }
    }
    'less_or_equal - {
      val less_or_equal: (Int, Int) => Boolean = (x, y) => calculator.leq(x, y)
      "0 <= 2 == true" - {
        less_or_equal(0, 2) ==> true
      }
      "2 <= 0 == false" - {
        less_or_equal(2, 0) ==> false
      }
    }
  }
}
