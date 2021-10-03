# Introduction
Welcome!

This is a simple application that queries the [Forismatic API](https://www.forismatic.com/en/api/) and returns a random quote via the command line.

This was completed as part of a coding exercise for [Gremlin](https://www.gremlin.com/). See the [OriginalInstructions.md](OriginalInstructions.md) the original prompt.

# Building/Running
This project uses (and includes) gradle for ease of execution. 
The project can be easily opened in a modern IDE, such as intelliJ. After cloning the repository, open the root folder as a project in intelliJ.

The project can be cleaned/built/tested via command line:
 - `.\gradlew clean`
 - `.\gradlew build`
 - `.\gradlew test`

The application can be run with:
 - `.\gradlew run`
 - `.\gradlew run --args="-lang English"`
 - `.\gradlew run --args="-l Russian"`
 - `.\gradlew run --args="-lRussian"`

"English" and "Russian" are accepted parameter values, and are not case sensitive. The default is `English`.

In intelliJ, you can execute the gradle run task with arguments by setting the configuration Task to be empty and the Arguments to: `run --args='--lang Russian'`
If the Cyrillic characters don't render correctly for you in intelliJ, see this for reference: https://stackoverflow.com/a/56430344

# Incomplete tasks/To be done
- Improve distribution: Modify the application to be able to be run with the command: "quotely"
- Improve the test suite. The test suite is incomplete and mostly skeleton or stubbed. Lots more tests need to be written. I attempted to give examples for each.
- Complete javadoccing.

# Future items
- Set up GitHub actions (or similar) for Continuous Development and Testing pipelines
- Handle more of the Forismatic API options (such as the key parameter)
- Handle other Forismatic response format types
- Handle arguments in Cyrillic. Potentially translate all text to Cyrillic when that is the language of choice. 
  - This would entail implementing/including a translation module and passing all text through it.
  
