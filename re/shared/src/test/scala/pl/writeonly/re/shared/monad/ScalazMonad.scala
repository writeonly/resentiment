package pl.writeonly.re.shared.monad

object ScalazMonad extends App {

  import scala.collection.Map
  import scalaz.Scalaz._

  val nestedMap = Map("Lisp" -> Map("Meta Language" -> Map("Haskell" -> "MonadsAreAwesome")))

  println(nestedMap.get("Lisp") >>= (_.get("Meta Language") >>= (_.get("Haskell"))))
  println(nestedMap.get("Lisp") >>= (_.get(":()") >>= (_.get("Haskell"))))
}
