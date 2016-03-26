enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.8" // or any other Scala version >= 2.10.2

scalaJSUseRhino in Global := false

persistLauncher in Compile := true

persistLauncher in Test := false

skip in packageJSDependencies := false

scalaJSOptimizerOptions ~= { _.withDisableOptimizer(true) }

ScalaJSPlugin.AutoImport.relativeSourceMaps := true

libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
  "com.gardner" %% "music-library" % "0.1",
  "org.webjars.npm" % "vexflow" % "1.2.41",
  "com.lihaoyi" %%% "utest" % "0.4.3" % "test"
)

jsDependencies ++= Seq(
  RuntimeDOM,
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
  "org.webjars.npm" % "vexflow" % "1.2.41" / "1.2.41/releases/vexflow-min.js"
)

testFrameworks += new TestFramework("utest.runner.Framework")
