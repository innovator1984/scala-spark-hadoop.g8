#!/bin/bash
# /*
#  * COMMAND FOR LOCAL MODE:
#  * -XX:+UseG1GC -Xmx40g -Xms40g
#  *
#  *  # Set SPARK_MEM if it isn't already set since we also use it for this process
#  * SPARK_MEM=$dollar${SPARK_MEM:-512m}
#  * export SPARK_MEM

#  * # Set JAVA_OPTS to be able to load native libraries and to set heap size
#  * JAVA_OPTS="$dollar$OUR_JAVA_OPTS"
#  * JAVA_OPTS="$dollar$JAVA_OPTS -Djava.library.path=$dollar$SPARK_LIBRARY_PATH"
#  * JAVA_OPTS="$dollar$JAVA_OPTS -Xms$dollar$SPARK_MEM -Xmx$dollar$SPARK_MEM"
#  */

# /*
#  * COMMAND FOR CLUSTER MODE:
# #!/bin/bash 
# SPARK_HOME=$spark_home$ \ 
# HADOOP_CONF_DIR=$hadoop_home$ \ 
# $spark_home$/bin/spark-submit \ 
# --master yarn \ 
# --deploy-mode client \ 
# --driver-java-options "-Dhive.metastore.uris=thrift://$hive_metaserver$" \ 
# --queue $scheduler_queue$ \
# $yarn_optimization$ \
# --class "ideas.Main" \ 
# ./$name$-$version$.jar
# */

java -jar -XX:+UseG1GC -Xmx40g -Xms40g ./$name$-$version$.jar

