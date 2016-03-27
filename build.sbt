enablePlugins(ScalaJSPlugin)

organization := "com.gardner"

name := "vexflow-scala-js"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8" // or any other Scala version >= 2.10.2

scalaJSUseRhino in Global := false

persistLauncher in Compile := true

persistLauncher in Test := false

skip in packageJSDependencies := false

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0",
  "org.webjars.npm" % "vexflow" % "1.2.41"
)

jsDependencies ++= Seq(
  "org.webjars.npm" % "vexflow" % "1.2.41" / "1.2.41/releases/vexflow-min.js"
)
