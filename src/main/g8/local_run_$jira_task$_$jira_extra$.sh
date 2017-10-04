#!/bin/bash
java -jar -XX:+UseG1GC -Xmx40g -Xms40g ./$name$-$version$.jar