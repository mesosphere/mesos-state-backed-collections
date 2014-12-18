import sbt._
import Keys._
import sbtrelease.ReleasePlugin._
import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences._

object MesosCollectionsBuild extends Build {
  lazy val root = Project(
    id = "mesos-state-backed-collections",
    base = file("."),
    settings =
      baseSettings ++
      releaseSettings ++
      Format.settings ++
      Seq(
        libraryDependencies ++= Dependencies.root,
        resolvers += Resolver.sonatypeRepo("public")
      )
  )

  lazy val baseSettings = Defaults.defaultSettings ++ Seq (
    organization := "mesosphere",
    scalaVersion := "2.11.4",
    scalacOptions in Compile ++=
      Seq(
        "-encoding", "UTF-8", "-target:jvm-1.6", "-deprecation",
        "-feature", "-unchecked", "-Xlog-reflective-calls", "-Xlint"
      )
  )

}

object Dependencies {
  import Dependency._

  val root = Seq(
    // runtime
    akka % "compile",
    mesos % "compile",

    // test
    Test.scalatest % "test"
  )
}

object Dependency {
  object V {
    // runtime deps versions
    val Akka = "2.3.8"
    val Mesos = "0.21.0"

    // test deps versions
    val ScalaTest = "2.2.1"
  }

  val akka =
    "com.typesafe.akka" %% "akka-actor" % V.Akka

  val mesos =
    "org.apache.mesos" % "mesos" % V.Mesos

  object Test {
    val scalatest =
      "org.scalatest" %% "scalatest" % V.ScalaTest
  }
}

object Format {
  lazy val settings = scalariformSettings ++ Seq(
    ScalariformKeys.preferences := FormattingPreferences()
      .setPreference(IndentWithTabs, false)
      .setPreference(IndentSpaces, 2)
      .setPreference(AlignParameters, true)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
      .setPreference(PreserveDanglingCloseParenthesis, true)
      .setPreference(CompactControlReadability, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(PreserveSpaceBeforeArguments, true)
      .setPreference(SpaceBeforeColon, false)
      .setPreference(SpaceInsideBrackets, false)
      .setPreference(SpaceInsideParentheses, false)
      .setPreference(SpacesWithinPatternBinders, true)
      .setPreference(FormatXml, true)
    )
}

