#!/bin/sh
cd tdd_pre_analysis_tool/
javac -d ../bin -sourcepath src/ -cp ".;libs/*" src/main/java/app/Main.java
cd ../bin/
java main.java.app.Main
