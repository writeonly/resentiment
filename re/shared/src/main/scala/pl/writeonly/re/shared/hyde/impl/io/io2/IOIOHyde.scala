package pl.writeonly.re.shared.hyde.impl.io.io2

import pl.writeonly.re.shared.hyde.common.states.api.ParallelStateIOIO
import pl.writeonly.re.shared.hyde.common.url.Domain
import scalaz.Scalaz._
import scalaz.ioeffect._
import slogging.StrictLogging

object IOIOHyde extends SafeApp with StrictLogging {

  private val domain = "https://www.writeonly.pl"

  override def run(args: List[String]): IO[Void, ExitStatus] =
    applyIO().attempt.map(_ => ExitStatus.DoNotExit)

  def apply(): Unit = main(Array())

  def applyIO(): ParallelStateIOIO = IOIOState.fromDomain(new Domain(domain)) |> IOIOState.run
}
