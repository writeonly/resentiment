# resentiment
Proof of concept - a portable application in Scala/JVM, Scala.js &amp; Scala Native

Run:
```bash
sbt clean compile test re/run reJS/run reJVM/run
```

Compile, test and generate coverage report:
```bash
sbt clean compile re/test coverage reJVM/test reJS/test && sbt coverageReport
```

