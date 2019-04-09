package pl.writeonly.re.shared.core

import utest._

object CoreTest extends TestSuite {
  override val tests: Tests = Tests {
    'core - {
      Core("Awesome")
    }
  }
}
