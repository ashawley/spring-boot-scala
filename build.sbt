name := "spring-boot-scala"

version := "0.1"

scalaVersion  := "2.12.6"

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-encoding",
  "utf8",
  "-language:implicitConversions")

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter" % "1.5.14.RELEASE",
  "org.springframework.boot" % "spring-boot-autoconfigure" % "1.5.14.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.14.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-data-jpa" % "1.5.14.RELEASE",
  "javax.persistence"        % "persistence-api" % "1.0.2",
  "com.h2database"           % "h2" % "1.4.197",
  "org.springframework.boot" % "spring-boot-starter-test" % "1.5.14.RELEASE" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.hamcrest" % "hamcrest-core" % "1.3" % "test"
)
