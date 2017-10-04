import Dependencies._

lazy val general = Seq(
  name := "$name$",
  organization := "$organization$",
  version := "$version$",
  scalaVersion := "$scala_version$"
)

lazy val dependencies = Seq(
  sparkCore % "provided",
  sparkSql % "provided",
  hadoopClient % "provided",
  configurator
)

lazy val root = (project in file("."))
  .settings(
    general,
    libraryDependencies ++= dependencies,
    dependencyOverrides ++= overrides,
    assemblyJarName in assembly := name.value + "-" + version.value + ".jar"
  )  
