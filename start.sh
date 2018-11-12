#!/bin/bash
java -Xms216M -Xmx216M -XX:+CMSClassUnloadingEnabled -jar $1 $2
