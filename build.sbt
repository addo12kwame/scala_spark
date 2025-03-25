ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "scala_spark",
    idePackagePrefix := Some("com.kwame.tutoriial")
  )
val sparkVersion = "3.5.5"
libraryDependencies ++= Seq( "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)