package pl.writeonly.re.shared.hyde.impl.io.io3

import pl.writeonly.re.shared.hyde.common.states.api.ParallelStateIOTask
import pl.writeonly.re.shared.hyde.common.url.Domain
import scalaz.Scalaz._
import scalaz.ioeffect._
import slogging.StrictLogging

object IOTaskHyde extends SafeApp with StrictLogging {

  private val domain = "https://www.writeonly.pl"

  override def run(args: List[String]): IO[Void, ExitStatus] =
    applyIO().attempt.map(_ => ExitStatus.DoNotExit)

  def apply(): Unit = main(Array())

  def applyIO(): ParallelStateIOTask = IOTaskState.fromDomain(new Domain(domain)) |> IOTaskState.run
}
