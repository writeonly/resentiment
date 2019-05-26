package pl.writeonly.re.shared.llvm

import pl.writeonly.re.shared.llvm.regex.Instruction
import scalaz.Scalaz._
import utest._

@SuppressWarnings(Array("org.wartremover.warts.Any"))
object InstructionTest extends TestSuite {
  val parse = Instruction.parseLine _

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
        case Some(word: Instruction) if word.token === Alloca =>
      }
    }

    'store - {
      assertMatch(parse(StoreLine)) {
        case Some(word: Instruction) if word.token === Store =>
      }
    }

  }
}
