name := "ScalaTask"

version := "0.1"

scalaVersion := "2.13.2"

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client" %% "core" % "2.1.5",

  "org.scalatest" %% "scalatest" % "3.1.1" % "test",

  "org.typelevel" %% "cats-effect" % "2.1.3",

  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
)