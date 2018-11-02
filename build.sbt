import org.scalajs.core.tools.linker.ModuleInitializer
import sbt.inConfig
import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}
import scoverage.ScoverageKeys.coverageEnabled

val mainClassString = "pl.writeonly.re.main.Main"
val mainClassSome = Some(mainClassString)

scapegoatVersion in ThisBuild := "1.3.8"

val sharedSettings = Seq(
  scalaVersion := "2.11.12",
  mainClass in (Compile, run) := Some("pl.writeonly.re.main.Main"),
  testFrameworks += new TestFramework("utest.runner.Framework"),
  libraryDependencies += "com.lihaoyi" %%% "utest" % "0.6.5" % "test",
  scalaJSUseMainModuleInitializer := true,
  scalaJSMainModuleInitializer := Some(
    ModuleInitializer.mainMethod(mainClassString, "main")
  ),
  addCompilerPlugin(scalafixSemanticdb),
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-Ypartial-unification",
    "-Yrangepos",
    "-Ywarn-unused",
    "-Ywarn-unused-import",
    "-Xfatal-warnings",
    "-Xlint",
  ),
  wartremoverErrors ++= Warts.unsafe,
  scapegoatVersion := "1.1.0",
)

val jsSettings = Seq(
  mainClass in Compile := mainClassSome,
  scalaJSUseMainModuleInitializer := true,
  coverageEnabled := true,
)

val jvmSettings = Seq(
  mainClass in Compile := mainClassSome,
  scalaJSUseMainModuleInitializer := true,
  coverageEnabled := true,
)

val nativeSettings = Seq(nativeLinkStubs := true)

lazy val re = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .withoutSuffixFor(NativePlatform)
  .crossType(CrossType.Full)
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings,
    inConfig(IntegrationTest)(ScalafmtPlugin.scalafmtConfigSettings),
    inConfig(IntegrationTest)(scalariformItSettings),
    inConfig(IntegrationTest)(scalafixConfigSettings(IntegrationTest)),
  )
  .settings(sharedSettings)
  .jsSettings(jsSettings)
  .jvmSettings(jvmSettings)
  .nativeSettings(nativeSettings)

lazy val reJS = re.js
lazy val reJVM = re.jvm.enablePlugins(ScalaJSPlugin)
lazy val reNative = re.native.enablePlugins(ScalaNativePlugin)
