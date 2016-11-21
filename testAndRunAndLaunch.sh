#!/bin/bash

#compile
javac -cp ./src:./out:./Junit/junit.jar -d ./out ./src/Model/*.java ./test/Model/*.java

#executez test
java -cp ./out:./Junit/junit.jar:./out/ Model.FormuleTest

#go to out folder


#execute MainView
