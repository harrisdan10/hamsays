@echo off

javac -d classes -classpath lib\app-utils-1.1.jar; src\com\hamsays\client\*.java src\com\hamsays\controller\*.java src\com\hamsays\*.java

jar --create --file hamsays-1.0.jar -C classes .
