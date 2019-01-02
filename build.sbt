import sbt.addCompilerPlugin

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    inThisBuild(List(
      organization := "jerry",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.12.6"
    )),
    name := "my-scala-js",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.6",
      "org.scalatest" %%% "scalatest" % "3.0.5" % "test",
      "com.thoughtworks.binding" %%% "dom" % "latest.release",

      // For Scala.js projects, or JS/JVM cross projects
      "com.thoughtworks.binding" %%% "futurebinding" % "latest.release",

      //JQuery
      "org.querki" %%% "jquery-facade" % "1.2"
    ),
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    scalaJSUseMainModuleInitializer := true
  )



// Automatically generate index-dev.html which uses *-fastopt.js
resourceGenerators in Compile += Def.task
{
  val source = (resourceDirectory in Compile).value / "index.html"
  val target = (resourceManaged in Compile).value / "index-dev.html"

  val fullFileName = (artifactPath in(Compile, fullOptJS)).value.getName
  val fastFileName = (artifactPath in(Compile, fastOptJS)).value.getName

  IO.writeLines(target,
    IO.readLines(source).map
    {
      line => line.replace(fullFileName, fastFileName)
    }
  )

  Seq(target)
}.taskValue
