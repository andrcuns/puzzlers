# puzzlers
UI testing project using cucumber and geb frameworks.
Windows, Linux and MAC with Chrome, Firefox and PhantomJs are supported.

## Running
### From commandline
To run all features with chrome browser

    ./gradlew runCukeTests
To run in a different browser

    ./gradlew runCukeTests -Pwebdriver=firefox
or a single tag

    ./gradlew runCukeTests -Ptags=@tagName
### From IDE
Features can be executed with jUnit by running class CukesRunner

Feature can be executed directly from feature file. Glue parameter _classpath:lv/neueda/puzzlers/web/steps_ must be added in Cucumber Java run configuration

IntelliJ Idea example:
![Alt text](/../screenshot/cucumber_ide.png?raw=true)
