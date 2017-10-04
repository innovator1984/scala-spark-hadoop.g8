package ideas

import org.apache.spark.sql.SparkSession

/*
 * COMMAND FOR LOCAL MODE:
 * -XX:+UseG1GC -Xmx40g -Xms40g
 *
 *  # Set SPARK_MEM if it isn't already set since we also use it for this process
 * SPARK_MEM=$dollar${SPARK_MEM:-512m}
 * export SPARK_MEM

 * # Set JAVA_OPTS to be able to load native libraries and to set heap size
 * JAVA_OPTS="$dollar$OUR_JAVA_OPTS"
 * JAVA_OPTS="$dollar$JAVA_OPTS -Djava.library.path=$dollar$SPARK_LIBRARY_PATH"
 * JAVA_OPTS="$dollar$JAVA_OPTS -Xms$dollar$SPARK_MEM -Xmx$dollar$SPARK_MEM"
 */

/*
 * COMMAND FOR CLUSTER MODE:
#!/bin/bash 
SPARK_HOME=$spark_home$ \ 
HADOOP_CONF_DIR=$hadoop_home$ \ 
$spark_home$/bin/spark-submit \ 
--master yarn \ 
--deploy-mode client \ 
--driver-java-options "-Dhive.metastore.uris=thrift://$hive_metaserver$" \ 
--queue $scheduler_queue$ \
$yarn_optimization$ \
--class "ideas.Main" \ 
./$name$-$version$.jar
*/

object Main extends Serializable {

  def initLog4j(): Unit = {
    import org.apache.log4j.Logger
    import org.apache.log4j.Level
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
  }

  def main(args: Array[String]): Unit = {
    println("Welcome to Spark!")
    initLog4j()
    lazy val spark: SparkSession = SparkSession.builder().appName("$jira_user$_$jira_task$_$jira_extra$")
      //.config("spark.sql.warehouse.dir", "/tmp_spark/spark-warehouse")
      //.config("spark.local.dir", "/tmp_spark/spark-temp")
      .config("spark.driver.maxResultSize", "300g")
      //.config("spark.worker.cleanup.enabled", "true")
      //.config("spark.worker.cleanup.interval", "900")
      .getOrCreate
      // .master("local[*]").getOrCreate
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._

    // %spark


  }
}