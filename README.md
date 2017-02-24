# puzzlers
UI testing project using cucumber and geb frameworks with ability to run tests in parallel.
Windows, Linux and MAC with Chrome, Firefox and PhantomJs are supported.

## Running
### From commandline
To run all features in sequence

    ./gradlew runCukeTestsInSequence
To run all features in parallel

    ./gradlew runCukeTestsInParallel
To run a single tag

    ./gradlew runCukeTestsInParallel -Ptags=@tagName
To run in firefox

    ./gradlew runCukeTestsInParallel -Pwebdriver=firefox
### From IDE
Features can be executed with jUnit by running class CukesRunner

Feature can be executed directly from feature file. Glue parameter _classpath:lv/neueda/puzzlers/web/steps_ must be added in Cucumber Java run configuration

IntelliJ Idea example:
![Alt text](/../screenshot/cucumber_ide.png?raw=true)
