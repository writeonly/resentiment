package pl.writeonly.re.shared.scalapipe

import scalaz.Scalaz._
import utest._

object ThrushTest extends TestSuite {
  def firstFunction(x: Int): Int = x + 1
  def secondFunction(x: Int): Int = x + 2
  def threeFunction(x: Int): Int = x + 3
  val data = 1
  override val tests: Tests = Tests {
    'into_with_lambda - {
      val result = 1 |> (_ + 2)
      result ==> 3
    }
    'into_with_method - {
      val result = 1 |> secondFunction
      result ==> 3
    }
    'into_with_method_end - {
      val result = data |>
        firstFunction |>
        secondFunction |>
        threeFunction
      result ==> 7
    }
    'into_with_method_front - {
      val result = 1
        .|>(firstFunction)
        .|>(secondFunction)
        .|>(threeFunction)
      result ==> 7
    }
    'into_with_method_front_into - {
      val result = 1
        .into(firstFunction)
        .into(secondFunction)
        .into(threeFunction)
      result ==> 7
    }
  }
}
