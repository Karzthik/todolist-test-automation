# QA Automation for to-do lists

## Framework Architecture & Design
This automation framework using *Selenium Webdriver* tool with *TestNG* test framework. 
According to the Page Object Model, the tests and element locators are placed separately. This will keep the code clean and easy to understand.
Another important advantage of POM is Independent of Tests automation and, it helps the repository to integrate with other tools like JUnit/TestNG/Cucumber/etc.
As this is single page application, I couldn't completely make use of POM framework.

## To run the automated tests
To run the tests on your windows machine. Please, follow below steps.

#### STEPS
##### Follow commands to run tests via cmd
1. 
2. `cd todo-test-automation`
3. `mvn install -DskipTests`
4. `mvn test -Dheadless=on` or `mvn test` (will take values from config.properties)

##### Follow commands to run tests from eclipse or intelliJ
1. `git clone `
2. Import project in IDE as a maven project
3. Right click on pom.xml -> Run As -> Maven install


#### REPORTS
Local report will be generated in `todo-test-automation\test-output\index.html`

#### HOW IT IS TESTED
When tests are executed from POM.xml or testng.xml, Execution will start from BaseTest.java because of the @BeforeSuite hook. 
in this before driver will be intialised and base url will be opened in the specified browser based on config.properties file, after that the program will start executing methods with @Test annotations.

#### WHAT IS BEING TESTED
To-Do application is tested with below Test scenarios. 
*** Test Cases ***
1.User should able to create new tasks in todo.
2.New Task that are added are added, displayed in a list, with the newest tasks at the top.
3.Task which is completed should be marked as completed.
4.Tasks those are active should be displayed in Active tab.
5.Completed tasks should be displayed in completed tab.
6.Clear all completed tasks in clear completed tab.
7.User should view only on Pending tasks in all to-dos.

## Project Structure

### src/test/resources/config.properties
Web configurations are stored in this file as key value pair. _**EnvironmentVariables.java**_ class will access all the values.

### src/main/java/utils
Utility classes that can be used across the project. *BrowserFactory.java* all browser can be configured here. *WebdriverWrapper.java* has common selenium common methods like explicit waits, etc.

### src/test/java/pages
Pages represents Application page, UI elements and methods are defined in these classes.

### src/test/java/testcases
All the tests in this package. e.g PostiveTest.java and NegativeTest.java.
BaseTest.java has hooks as a pre-requiste for tests.

#### CI/CD with Github-Actions
As PR is created or PR is merged to Main branch, github-actions will be trigged. This will help in regression tests and continuous deployment.
_**https://github.com/survepravin/todo-test-automation/actions/workflows/maven.yml**_
