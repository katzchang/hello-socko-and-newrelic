ThisBuild / scalaVersion := "2.11.12"
ThisBuild / organization := "com.example"

lazy val helloSocko = (project in file("."))
  .settings(
    name := "Hello Socko",
    libraryDependencies += "org.mashupbots.socko" %% "socko-webserver" % "0.6.0",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.20",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )

