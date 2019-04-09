package pl.writeonly.re.shared.scalapipe

// trait for cake pattern
trait ScalaPipeOps {
  implicit def toPipe[A](a: A): ScalaPipe[A] = ScalaPipe(a)

  class ScalaPipe[A](a: A) {
    def |>[B](f: A => B): B = f(a)
  }

  object ScalaPipe {
    def apply[A](v: A): ScalaPipe[A] = new ScalaPipe(v)
  }

}

// object for static import
object ScalaPipeOps extends ScalaPipeOps
