rm -rf classes
mkdir classes

echo "Compiling these classes: $(find src -name "*.java")"

#javac -classpath ~/apps/processing-3.2.1/core/library/core.jar \
javac -classpath /Applications/Processing.app/Contents/Java/core.jar \
  -d classes \
  -Xlint:unchecked \
  $(find src -name "*.java")
