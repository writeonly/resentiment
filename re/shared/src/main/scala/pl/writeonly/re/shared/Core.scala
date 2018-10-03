package pl.writeonly.re.shared

object Core {
  def apply(args: Array[String]): Unit = {
    println("Hello Scala!")
  }

  def apply(arg: String): Unit = {
    println(s"Hello $arg!")
  }
}
