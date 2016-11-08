rm -rf classes
mkdir classes

shopt -s globstar  # Make sure ./**/*.* works
javac -classpath ~/apps/processing-3.2.1/core/library/core.jar \
  -d classes \
  -Xlint:unchecked \
  src/**/*.java
