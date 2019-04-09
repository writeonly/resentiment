package pl.writeonly.re.shared.core

trait Core {
  def apply(arg: String): Unit
}

object Core extends Core {
  override def apply(arg: String): Unit = {
    StrictLoggingCore(arg)
    LazyLoggingCore(arg)
  }
}
