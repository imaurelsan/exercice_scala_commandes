ThisBuild / scalaVersion := "2.13.16"
ThisBuild / organization := "example"
ThisBuild / version := "0.1.0-SNAPSHOT"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test

// Exécute les tests même si plusieurs suites sont disponibles.
testFrameworks += new TestFramework("org.scalatest.tools.Framework")
