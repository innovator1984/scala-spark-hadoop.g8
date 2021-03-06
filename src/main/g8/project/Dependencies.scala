import sbt._

object Dependencies {

  lazy val sparkVersion = "$spark_version$"
  lazy val hadoopVersion = "$hadoop_version$"

  lazy val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  lazy val hadoopClient = "org.apache.hadoop" % "hadoop-client" % hadoopVersion
  lazy val configurator = "com.typesafe" % "config" % "1.3.1"

  lazy val overrides = Seq(
    "commons-net" % "commons-net" % "3.1",
    "com.google.guava" % "guava" % "14.0.1",
    "com.google.code.findbugs" % "jsr305" % "3.0.0",
    "io.netty" % "netty" % "3.8.0.Final",
    "io.netty" % "netty-all" % "4.0.29.Final"
  )
}
