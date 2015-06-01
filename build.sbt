scalaVersion := "2.11.5"
scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.9",
  "com.typesafe.akka" %% "akka-persistence-experimental" % "2.3.9",
  "io.reactivex" %% "rxscala" % "0.23.0",
  "io.reactivex" % "rxswing" % "0.21.0", // for Swing Scheduler in suggestions
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.scala-lang.modules" %% "scala-swing" % "1.0.1",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5",
  "com.squareup.retrofit" % "retrofit" % "1.0.0",
  "org.scala-lang.modules" %% "scala-async" % "0.9.2"
)

mainClass in Compile := Some("org.example.Hello")
