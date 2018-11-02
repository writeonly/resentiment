# resentiment
Proof of concept - a portable application in Scala/JVM, Scala.js &amp; Scala Native

Clone:
```bash
git clone https://github.com/writeonly/resentiment.git
cd resentiment
```

Refactor and reformat:
```bash
sbt scalafix test:scalafix it:scalafix && \
sbt scalafmtSbt scalafmt test:scalafmt it:scalafmt
```

Check lint and format:
```bash
sbt 'scalafix --check' 'test:scalafix --check' 'it:scalafix --check' && \
sbt scalafmtSbtCheck scalafmtCheck test:scalafmtCheck it:scalafmtCheck 
```

Compile, test and generate coverage report:
```bash
sbt clean compile test:compile it:compile re/test && \
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test && \
sbt coverageReport
```

Check:
```bash
sbt scalastyle test:scalastyle it:scalastyle && \
sbt scapegoat cpd stats
```

All:
```bash
sbt scalafix test:scalafix it:scalafix && \
sbt scalafmtSbt scalafmt test:scalafmt it:scalafmt && \
sbt clean compile test:compile it:compile re/test && \
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test && \
sbt coverageReport && \
sbt scalastyle test:scalastyle it:scalastyle && \
sbt scapegoat cpd stats
```