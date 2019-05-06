package pl.writeonly.re.shared.llvm

import pl.writeonly.re.shared.llvm.regex.Token
import scalaz.Scalaz._
import utest._

@SuppressWarnings(Array("org.wartremover.warts.Any"))
object TokenTest extends TestSuite {
  val parse = Token.parseLine _

  val Alloca = "alloca"
  val Store = "store"

  val DefineLine = "define i32 @main(i32, i8**) #0 {"
  val AllocaLine = "  %3 = alloca i32, align 4"
  val StoreLine = "  store i32 0, i32* %3, align 4"

  override val tests: Tests = Tests {
    'define - {
      assertMatch(parse(DefineLine)) {
        case None =>
      }
    }

    'alloca - {
      assertMatch(parse(AllocaLine)) {
        case Some(word: Token) if word.token === Alloca =>
      }
    }

    'store - {
      assertMatch(parse(StoreLine)) {
        case Some(word: Token) if word.token === Store =>
      }
    }

  }
}
