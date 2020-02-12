ThisBuild / scalaVersion := "2.11.12"
ThisBuild / organization := "com.example"

val currentDirectory = new java.io.File(".").getCanonicalPath

lazy val helloSocko = (project in file("."))
  .settings(
    fork := true,
    run / javaOptions += s"-javaagent:${currentDirectory}/newrelic/newrelic.jar",

    name := "Hello Socko",
    libraryDependencies += "com.newrelic.agent.java" % "newrelic-api" % "5.10.0",
    libraryDependencies += "org.mashupbots.socko" %% "socko-webserver" % "0.6.0",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.20",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )

