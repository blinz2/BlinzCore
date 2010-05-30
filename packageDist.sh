mvn clean package
mkdir dist
mv target/BlinzCore*.jar dist/BlinzCore.jar
mvn javadoc:javadoc
mv target/site/apidocs dist/javadoc
cp -r src/main/java dist/src
rm -r target
