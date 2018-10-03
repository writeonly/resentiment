import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}

val sharedSettings = Seq(
  scalaVersion := "2.11.12",
  mainClass in(Compile, run) := Some("pl.writeonly.re.main.Main")
)

lazy val re = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .withoutSuffixFor(NativePlatform)
  .crossType(CrossType.Full)
  .settings(sharedSettings)
  .jsSettings()
  .jvmSettings(scalaJSUseMainModuleInitializer := true)
  .nativeSettings(nativeLinkStubs := true)

lazy val reJS = re.js
lazy val reJVM = re.jvm.enablePlugins(ScalaJSPlugin)
lazy val reNative = re.native.enablePlugins(ScalaNativePlugin)