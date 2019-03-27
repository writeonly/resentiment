package pl.writeonly.re.shared.scalapipe

import scalaz.Scalaz._
import utest._

object ScalaPipeOptWithTraitTest extends TestSuite with ScalaPipeOps {
  def add2(x: Int): Int = x + 2

  override val tests: Tests = Tests {
    'into_with_lambda - {
      val result = 1 ||> (_ + 2)
      assert(result === 3)
    }
    'into_with_method - {
      val result = 1 ||> add2
      assert(result === 3)
    }
  }
}
