name := "Cookbook Html"

version := "1.0.0"

organization := "cookbook.liftweb.net"

scalaVersion := "2.9.2"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

parallelExecution in Test := false

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.5-RC2"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftmodules" %% "lift-jquery-module" % (liftVersion + "-2.2"),
    "net.liftmodules" %% "textile" % (liftVersion + "-1.3"),
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback" % "logback-classic" % "1.0.6",
    "org.specs2" %% "specs2" % "1.12.1" % "test",
    "net.liftweb" %% "lift-testkit" % liftVersion % "test"
  )
}



unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }


