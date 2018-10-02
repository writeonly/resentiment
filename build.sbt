import sbtcrossproject.CrossPlugin.autoImport.crossProject

lazy val resentiment = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .settings(scalaVersion := "2.11.12")

lazy val resentimentJS     = resentiment.js
lazy val resentimentJVM    = resentiment.jvm
lazy val resentimentNative = resentiment.native
