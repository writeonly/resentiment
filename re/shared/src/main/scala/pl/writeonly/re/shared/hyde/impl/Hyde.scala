package pl.writeonly.re.shared.hyde.impl

import java.text.NumberFormat

import scala.util.Try

import pl.writeonly.re.shared.hyde.impl.io.io1.IOHyde
import pl.writeonly.re.shared.hyde.impl.io.io2.IOIOHyde
import pl.writeonly.re.shared.hyde.impl.io.io3.IOTaskHyde
import pl.writeonly.re.shared.hyde.impl.oo.oo1.StandardExceptionHyde
import pl.writeonly.re.shared.hyde.impl.oo.oo2.WrappingExceptionHyde
import pl.writeonly.re.shared.hyde.impl.oo.oo3.TryHyde
import pl.writeonly.re.shared.hyde.impl.std.std1.EitherHyde
import pl.writeonly.re.shared.hyde.impl.std.std2.EitherBeginHyde
import pl.writeonly.re.shared.hyde.impl.std.std3.EitherEndHyde
import pl.writeonly.re.shared.hyde.impl.std.std4.FutureHyde
import pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty1.DisjunctionHyde
import pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty2.DisjunctionBeginHyde
import pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty3.DisjunctionEndHyde
import pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty4.TaskHyde

object Hyde {

  def main(implicit args: Array[String]): Unit = {

    oo

    std()

    thirdParty()

    io()

    println("end of program")
  }

  def oo(implicit args: Array[String]): Unit = {
    println("StandardExceptionHyde")
    val oo1 = Try(StandardExceptionHyde.main(args))
    println("StandardExceptionHyde " + oo1.toString)

    println("WrappingExceptionHyde")
    val oo2 = Try(WrappingExceptionHyde.main(args))
    println("WrappingExceptionHyde " + oo2.toString)

    val tryState = time("TryHyde") {
      TryHyde.apply()
    }
    println(tryState.throwableList.size.toString)
  }

  def std(): Unit = {

    val eitherState = time("EitherHyde") {
      EitherHyde.apply()
    }
    println(eitherState.throwableList.size.toString)

    val eitherBeginState = time("EitherBeginHyde") {
      EitherBeginHyde.apply()
    }
    println(eitherBeginState.throwableList.size.toString)

    val eitherEndState = time("EitherEndHyde") {
      EitherEndHyde.apply()
    }
    println(eitherEndState.throwableList.size.toString)

    val futureState = time("FutureHyde") {
      FutureHyde.apply()
    }
    println(futureState.throwableList.size.toString)
  }

  def thirdParty(): Unit = {
    val disjunctionState = time("DisjunctionHyde") {
      DisjunctionHyde.apply()
    }
    println(disjunctionState.throwableList.size.toString)

    val disjunctionBeginState = time("DisjunctionBeginHyde") {
      DisjunctionBeginHyde.apply()
    }
    println(disjunctionBeginState.throwableList.size.toString)

    val disjunctionEndState = time("DisjunctionEndHyde") {
      DisjunctionEndHyde.apply()
    }
    println(disjunctionEndState.throwableList.size.toString)

    val taskState = time("TaskHyde") {
      TaskHyde.apply()
    }
    println(taskState.throwableList.size.toString)
  }

  def io(): Unit = {

    val noException6State = time("IOHyde") {
      IOHyde.apply()
    }
    println(noException6State.throwableList.size.toString)

    time("IOIOHyde") {
      IOIOHyde.apply()
    }
    time("IOTaskHyde") {
      IOTaskHyde.apply()
    }
  }

  def time[R](name: String)(block: => R): R = {
    println(name)

    val startTime = System.nanoTime()
    val result = block
    val stopTime = System.nanoTime()

    val t = stopTime - startTime

    val formatter = NumberFormat.getIntegerInstance

    println("Elapsed time: " + formatter.format(t) + "ns")
    result
  }
}
