package pl.writeonly.re.shared.monad

object ScalazMonad extends App {

  import scala.collection.Map
  import scalaz.Scalaz._

  val nestedMap = Map("key1" -> Map("key2" -> Map("key3" -> "MonadsAreAwesome")))

  println(nestedMap.get("key1") >>= (_.get("key2") >>= (_.get("key3"))))
  println(nestedMap.get("key1") >>= (_.get(":()") >>= (_.get("key3"))))
}
