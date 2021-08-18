lazy val root: Project =
  project.in(file("."))
    .settings(

      name         := "natural",
      version      := "0.1.0",
      scalaVersion := "3.0.1",

      libraryDependencies ++=
        Seq("com.novocode" % "junit-interface" % "0.11" % "test"))
