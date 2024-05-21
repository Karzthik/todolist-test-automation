# QA Automation for to-do lists

## Framework Architecture & Design
This automation framework developed using *Selenium Webdriver* tool with *TestNG* test framework. 

## To run the automated tests
To run the tests on your windows machine. Please, follow below steps.

##### Follow commands to run tests from Eclipse or intelliJ

1. git clone https://github.com/Karzthik/todolist-test-automation
2. Import project in IDE (Eclipse) as a maven project.
3. Right click on pom.xml -> Run As -> Maven install.

#### REPORTS
Local report will be generated in todolist-test-automation\target\surefire-reports\index.html

#### HOW IT IS TESTED
When tests are executed from POM.xml or testng.xml, Execution will start from BaseTest.java because of the @BeforeSuite hook. 
Driver will be initialised and base URL will be opened in the specified browser based on config.properties file, after that the program will start executing methods with @Test annotations.

#### WHAT IS BEING TESTED

To-Do application is tested based on below Acceptance Criteria.

*** Test Cases ***

1.User should be able to create new tasks in todos.
2.New Task that are added are added, displayed in a list, with the newest tasks at the top.
3.Task which is completed should be marked as completed.
4.Tasks those are active should be displayed in Active tab.
5.Completed tasks should be displayed in completed tab.
6.Clear all completed tasks in clear completed tab.
7.User should view only on Pending tasks in all to-dos.


## Project Structure

### src/test/resources/config.properties
Web configurations are stored in config.properties file as key value pair. 
**EnvironmentVariables.java** class access all the values.

### src/main/java/utils
Utility classes can be used across the project. 
BrowserFactory.java has browser configurations.
WebdriverWrapper.java has selenium common methods.

### src/test/java/pages
Pages represents Application page, UI elements and methods.

### src/test/java/testcases
All the tests stored in this package as TestCase.java.
BaseTest.java has hooks as a pre-requisite for tests.
