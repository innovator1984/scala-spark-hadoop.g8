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