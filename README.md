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
sbt 're/scalafix --check' 're/test:scalafix --check' 're/it:scalafix --check' && \
sbt scalafmtSbtCheck re/scalafmtCheck re/test:scalafmtCheck re/it:scalafmtCheck
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
sbt re/scalafix re/test:scalafix re/it:scalafix && \
sbt re/scalafmtSbt re/scalafmt re/test:scalafmt re/it:scalafmt && \
sbt clean re/compile re/test:compile re/it:compile re/test && \
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test && \
sbt coverageReport && \
sbt scalastyle test:scalastyle it:scalastyle && \
sbt scapegoat cpd stats
```

All for travis-ci:
```bash
sbt 're/scalafix --check' 're/test:scalafix --check' 're/it:scalafix --check' && \
sbt scalafmtSbtCheck re/scalafmtCheck re/test:scalafmtCheck re/it:scalafmtCheck && \
sbt clean re/compile re/test:compile re/it:compile re/test && \
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test && \
sbt coverageReport && \
sbt scalastyle test:scalastyle it:scalastyle && \
sbt scapegoat cpd stats
```
