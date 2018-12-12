# resentiment

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/53879302eadd48c38adcbbdc68e7ccfb)](https://app.codacy.com/app/kamil-adam/resentiment?utm_source=github.com&utm_medium=referral&utm_content=writeonly/resentiment&utm_campaign=Badge_Grade_Dashboard)

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
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test coverageReport && 
sbt coverageAggregate
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
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test coverageReport && \ 
sbt coverageAggregate && \
sbt scalastyle test:scalastyle it:scalastyle && \
sbt scapegoat cpd stats
```

All for travis-ci:
```bash
sbt 'scalafix --check' 'test:scalafix --check' 'it:scalafix --check' &&
sbt scalafmtSbtCheck scalafmtCheck test:scalafmtCheck it:scalafmtCheck &&
sbt clean re/compile re/test:compile re/it:compile &&
sbt coverage reJS/test reJVM/test reJS/it:test reJVM/it:test coverageReport &&
sbt coverageAggregate &&
sbt scalastyle test:scalastyle it:scalastyle &&
sbt scapegoat cpd stats
```
