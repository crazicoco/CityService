# !/bin/bash
set -e

echo `service mysql status`

echo "1.启动mysql"

service mysql start

sleep 3
echo `service mysql status`

echo "2.初始化数据"

mysql < /mysql/definition.sql
mysql < /mysql/insertion.sql

echo "3.导入数据完毕"

echo `service mysql status`
echo "mysql 启动、初始化完毕"
