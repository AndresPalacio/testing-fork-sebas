# **Template Serenity**

## Introduction 🚀

Template Serenity in Java.

## Preconditions 📋

---
- Java v17
- Gradle v7.6
- IntelliJ IDEA with plugins:
    + ```Cucumber```
    + ```Gherkin```
    + ```Kotlin```
- Environment variables
    + Gradle → ```GRADLE_HOME```
    + JDK → ```JAVA_HOME```
## Built with 🛠

---
- **JAVA** - Programming language
- **BDD** - Development strategy
- **Screenplay** - Design pattern
- **Gherkin** - DSL to write requirements
- **Gradle** - Dependency manager
- **Cucumber** - Tool to automate using BDD
- **Serenity BDD** - Automation framework & report generation
- **RestAssured** - Library to consume microservices

## Project Structure 🚧

* ```src/main/java/com/serenity/template/web```
``` 
+ models
    They are classes with which we build our data models, such as JSON schemas.

+ questions
    They are dedicated classes to perform validations of a set of specific expected results, when using Hard Asserts the class will always return true. Implements Performable so you can use the created actor.
    In the questions, the ensure "That" construct was used. It's important to remember that even though the ensure clause in the question class always returns true, if the assert statement is incorrect, it never reaches this return.

+ tasks
    These are classes that perform high-level actions. Implements Performable so you can use the created actor.

+ userinterface
    They are classes where the user interface elements such as text fields, buttons, copies, labels, etc. are mapped. In this case it does not apply because it is a purely APIS exercise.

+ utils
    They are classes that contain common functionalities, such as constants, utilities for working with dates, utilities for JSONS files, Serenity Sessions, etc.
```

* ```src/main/java/com/serenity/template/web```
```
+ runners
    They are classes that represent the starting point to execute the scenarios, each class in this package is associated with a .feature file and with a class from the stepdefinitions package.

+ stepdefinitions
    They are classes where the steps of the scenario written in gherkin are defined and connected with cucumber to translate them into the programming language. It also contains the classes that execute the @Before and @After methods which are in the hooks folder.
 ```

* ```src/test/resources/features```
```
+ features
    It is the folder where the .feature files are located, which are responsible for containing the scenarios written in gherkin. For each feature there must be a runner and stepdefinition class.
```

## Report 📑

---
At the end of the execution of the tests, the aggregate is performed and the following report is generated:

**Serenity reports** ```target/site/serenity/index.html```

## VCS 🔀

---
Git is used as a version control system.

## Contributor

**Sebastian Ramirez** - [Contact](mailto:sebastianramirez.g@outlook.com)

---
