##
# **Evernote Test Automation**

The Test Automation Framework is created for automating Login, Logout, Create Note, View notes. 

### Scripting Language

Java is used as the scripting language with selenium framework. Also the Cucumber BDD has followed to develop the script. Cucumber files will help in improving the readability of test cases for users without coding background.
- Java version: 1.8

### Folder Structure

The Test Automation Suite is having below folders.

- **features (src/test/features)** : Feature files have been created based on each feature which is under test. The different scenarios and corresponding steps in each test case that is linked to the particular feature have been listed in the same feature file.
- **stepDefinitions (src/test/java)** : Source folder has been used to list the modules used to implement the source files for corresponding feature files steps. Emphasis has been kept to reuse the codes wherever possible using file level methods.
- **pageObjects (src/test/java)** : This folder has been used to save the locators and perform the automation task for each page. Each StepDefinition file corresponds to each pageObjects file.
- **common (src/test/java)** : Contains the common stepdefinitions used across the project. Eg: Login, Logout etc.
- **baseClasses (src/test/java)** : Folder used to store common functionalities across the project. Eg: Initialize the browser, custom waits, property file handling, hooks etc.
- **resources (src/test/resources)** : Folder used to store resources like driver files etc.


# baseClasses

BaseClasses having following files.

#### Hooks.java file
The file contains the operation needs to be done before and after the script execution.

#### Init.java file
Used to initialize the browser and the configuration file .

#### JSWaiter.java file
This file is created inside the baseClass and is used to store all custom waits which are being used to wait for and perform some actions. It will be useful in cases where Selenium inbuilt wait statements are not useful.

#### PropHandler.java file
This file used to handle the property file. Set and get the properties from property file

#### RunTest.java file
This file used to Run the selenium script

#### config.properties file
This file is in the root directory contains all the configuration properties like url, username, password etc.

# Creation of a test case

The following steps briefly describe how a new test case can be added to the framework.

1. Create a maven project and add all dependencies.
2. Create a feature file, if required. Add the scenario and steps in the .feature file in Gherkin format.
2. Map the required page locators to the corresponding page class in the pageObjects folder.
3. Add the test cases scripts in the corresponding file in the StepDefinition folder. Do create a new script file if required. The steps and classes which are already implemented may be reused to reduce duplicate scripting.

### Test Execution
Create a JUnit runner to run the test. Add the feature file location in cucumber options. Run the script as junit.