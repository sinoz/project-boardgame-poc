name := "rotbord"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val gdxVersion = "1.9.4"
  val gdxDeps = Seq(
    "com.badlogicgames.gdx" % "gdx" % gdxVersion,
    "com.badlogicgames.gdx" % "gdx-platform" % gdxVersion classifier "natives-desktop",
    "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % gdxVersion
  )

  val otherDeps = Seq(
    // TODO
  )

  gdxDeps ++ otherDeps
}
    