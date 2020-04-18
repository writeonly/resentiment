package pl.writeonly.re.shared.monad

object ScalaMonad extends App {

  import scala.collection.Map

  val nestedMap = Map("Lisp" -> Map("Meta Language" -> Map("Haskell" -> "MonadsAreAwesome")))

  println(nestedMap.get("Lisp") flatMap (_.get("Meta Language") flatMap (_.get("Haskell"))))
  println(nestedMap.get("Lisp") flatMap (_.get(":()") flatMap (_.get("Haskell"))))
}
