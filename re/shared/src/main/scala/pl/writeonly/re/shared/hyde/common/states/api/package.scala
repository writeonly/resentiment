package pl.writeonly.re.shared.hyde.common.states

import scala.concurrent.Future

import scalaz.concurrent.Task
import scalaz.effect.IO
import scalaz.ioeffect.{IO => IOIO, Task => IOTask}

package object api {
  type ParallelStateFuture = Future[EitherAPIState]

  type ParallelStateIO = IO[DisjunctionAPIState]

  type ParallelStateTask = Task[DisjunctionAPIState]

  type ParallelStateIOIO = IOIO[Throwable, DisjunctionAPIState]

  type ParallelStateIOTask = IOTask[DisjunctionAPIState]
}
