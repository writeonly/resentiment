package pl.writeonly.re.shared.monad

object ScalaMonad extends App {

  import scala.collection.Map

  val nestedMap = Map("key1" -> Map("key2" -> Map("key3" -> "MonadsAreAwesome")))

  println(nestedMap.get("key1") flatMap (_.get("key2") flatMap (_.get("key3"))))
  println(nestedMap.get("key1") flatMap (_.get(":()") flatMap (_.get("key3"))))
}
