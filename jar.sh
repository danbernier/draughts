./compile.sh

jar cvf draughts.jar -C classes $(find classes -name "*.class")

# Clean up after yourself. You only compiled to jar it up.
rm -rf classes
