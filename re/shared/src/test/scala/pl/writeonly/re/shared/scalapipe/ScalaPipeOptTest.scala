package pl.writeonly.re.shared.scalapipe

import pl.writeonly.re.shared.scalapipe.ScalaPipeOps._
import utest._

object ScalaPipeOptTest extends TestSuite {
  def add2(x: Int): Int = x + 2

  override val tests: Tests = Tests {
    'pipe_with_lambda - {
      val result = 1 ||> (_ + 2)
      result ==> 3
    }
    'pipe_with_method - {
      val result = 1 ||> add2
      result ==> 3
    }
  }
}
