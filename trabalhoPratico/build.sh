#!/usr/bin/env bash
# Compila o código principal e os testes (Java 17). Uso: ./build.sh
set -euo pipefail
cd "$(dirname "$0")"
LIBS=$(ls libs/*.jar 2>/dev/null | tr '\n' ':' || true)
if [ -z "$LIBS" ]; then
  echo "Coloque os .jar em libs/ (veja libs/LEIAME.txt)"; exit 1
fi
rm -rf out && mkdir -p out/main out/test
javac --release 17 -encoding UTF-8 -d out/main $(find src/main/java -name '*.java')
javac --release 17 -encoding UTF-8 -d out/test -cp "out/main:$LIBS" $(find src/test/java -name '*.java')
echo "build OK"
