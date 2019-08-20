package pl.writeonly.re.shared.hyde.impl.io.io1

import pl.writeonly.re.shared.hyde.common.states.api._
import pl.writeonly.re.shared.hyde.common.url.Domain
import scalaz.ImmutableArray
import scalaz.Scalaz._
import scalaz.effect._

object IOHyde extends SafeApp {

  private val domain = "https://www.writeonly.pl"

  override def run(args: ImmutableArray[String]): IO[Unit] = applyIO().map(_.showResult())

  def apply(): DisjunctionAPIState = applyIO().unsafePerformIO()

  def applyIO(): ParallelStateIO = IOState.fromDomain(new Domain(domain)) |> IOState.run
}
