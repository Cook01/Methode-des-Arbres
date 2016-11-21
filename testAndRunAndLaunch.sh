#!/bin/bash

#compile
javac -cp ./src:./out:./Junit/junit.jar -d ./out ./src/Model/*.java ./src/Controller/*.java ./test/Model/*.java

#executez test
java -cp ./out:./Junit/junit.jar:./out/ Model.FormuleTest

#go to out folder
cd out

#execute MainView
java Controller.MainController