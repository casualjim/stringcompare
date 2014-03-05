name := "stringcompare"

scalaVersion := "2.10.3"

libraryDependencies += "com.github.axel22" %% "scalameter" % "0.4" % "test"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

parallelExecution in Test := false
