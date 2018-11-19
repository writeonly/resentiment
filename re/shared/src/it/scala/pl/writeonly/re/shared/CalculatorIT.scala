package pl.writeonly.re.shared

import scalaprops.{Property, Scalaprops}

object CalculatorIT extends Scalaprops {
  val calculator = new Calculator()

  val addition: (Int, Int) => Int = (x, y) => calculator.add(x, y)
  val additionTest = Property.forAll { (a: Int, b: Int) =>
    addition(a, b) == a + b
  }

  val multiplication: (Int, Int) => Int = (x, y) => calculator.mul(x, y)
  val multiplicationTest = Property.forAll { (a: Int, b: Int) =>
    multiplication(a, b) == a * b
  }

  val lessOrEqual: (Int, Int) => Boolean = (x, y) => calculator.leq(x, y)
  val lessOrEqualTest = Property.forAll { (a: Int, b: Int) =>
    lessOrEqual(a, b) == (a <= b)
  }
}
