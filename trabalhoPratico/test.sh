#!/usr/bin/env bash
# Compila e executa TODOS os testes de src/test/java (classes *Test), com asserções habilitadas (-ea).
set -euo pipefail
cd "$(dirname "$0")"
./build.sh
LIBS=$(ls libs/*.jar | tr '\n' ':')
CLASSES=$(cd src/test/java && find . -name '*Test.java' | sed 's|^\./||; s|\.java$||; s|/|.|g' | tr '\n' ' ')
java -ea -Dfile.encoding=UTF-8 -cp "out/main:out/test:$LIBS" org.junit.runner.JUnitCore $CLASSES
