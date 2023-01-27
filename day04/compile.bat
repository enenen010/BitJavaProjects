@echo off
echo "java file name=class name?"
set /p cname=

del %cname%.class
javac -encoding utf8 %cname%.java
cls

java %cname%
PAUSE
