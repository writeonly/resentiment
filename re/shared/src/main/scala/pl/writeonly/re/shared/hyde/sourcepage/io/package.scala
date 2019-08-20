package pl.writeonly.re.shared.hyde.sourcepage

import pl.writeonly.re.shared.hyde.sourcepage.thirdparty.SourcePageDisjunction
import scalaz.effect.IO
import scalaz.ioeffect.{IO => IOIO, Task => IOTask}

package object io {
  type SourcePageIO = IO[SourcePageDisjunction]

  type SourcePageIOIO = IOIO[Throwable, SourcePageDisjunction]

  type SourcePageIOTask = IOTask[SourcePageDisjunction]
}
