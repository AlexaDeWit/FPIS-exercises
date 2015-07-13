val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.3"
val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
lazy val commonSettings =  Seq(
  version := "0.0.1",
  scalaVersion := "2.11.6"
)
lazy val root = (project in file(".")).
  settings( commonSettings: _* ).
  settings(
    name := "fpis-exercises",
    libraryDependencies ++= Seq(
      scalatest,
      scalaz
    )
  )

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits")
