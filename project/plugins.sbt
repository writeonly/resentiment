// cross project
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.5.0")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "0.5.0")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.24")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.3.8")
//coverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

// static code analysis read-write
//// Scalafix - Refactoring and linting tool for Scala
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.0")
//// Scalafmt - Code formatter for Scala
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")
//// sbt-scalariform - sbt plugin adding support for source code formatting using Scalariform
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")
