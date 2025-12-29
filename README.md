# RestAssuredTestNGFramework [![Run Spotify Rest API Tests and Publish Reports](https://github.com/NagarjunaSK-Git/BaseRestAPITestFramework/actions/workflows/restapitests.yml/badge.svg?branch=master)](https://github.com/NagarjunaSK-Git/BaseRestAPITestFramework/actions/workflows/restapitests.yml)
An API test automation framework using Rest Assured (6.0.0+), Java (19), TestNG (7.11+), Maven and Allure reports (2.32+)
for Spotify APIs.

## Quick Start
1) Install [Java JDK19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
2) Download [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Tech stack
<a href="https://rest-assured.io/" target="_blank" rel="noreferrer"> 
<img src="https://avatars.githubusercontent.com/u/19369327?s=200&v=4" alt="Rest Assured" width="40" height="40"/> </a>
<a href="https://testng.org/" target="_blank" rel="noreferrer"> 
<img src="https://avatars.githubusercontent.com/u/12528662?s=200&v=4" alt="testng" width="40" height="40"/> </a>
<a href="https://www.java.com" target="_blank" rel="noreferrer">
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>
<a href="https://allurereport.org/" target="_blank" rel="noreferrer">
<img src="https://allurereport.org/public/img/allure-report.svg" alt="Cucumber" width="40" height="40"/> </a>
<a href="https://www.jenkins.io" target="_blank" rel="noreferrer"> 
<img src="https://www.vectorlogo.zone/logos/jenkins/jenkins-icon.svg" alt="jenkins" width="40" height="40"/> </a> 


## Compiling test code through Maven
 Load the pom.xml and run `mvn clean test-compile`

## Running tests through Maven
All these maven runtime parameters are mandatory and stored in system properties.
To run local, Kindly update the run configurations in IDE for test execution.

* Run test command `mvn clean test -Dgroups="smoke" -DthreadCount="10" -DTEST_ENVIRONMENT="qa"  -DREFRESH_TOKEN="YOUR_REFRESH_TOKEN"`
* Run test for regression `mvn clean test -Dgroups="regression" -DthreadCount="10" -DTEST_ENVIRONMENT="qa"  -DREFRESH_TOKEN="YOUR_REFRESH_TOKEN"`
* Run test for serially `mvn clean test -Dgroups="regression" -DthreadCount="1" -DTEST_ENVIRONMENT="qa"  -DREFRESH_TOKEN="YOUR_REFRESH_TOKEN"`
* Run test for parallel with 5 threads `mvn clean test -Dgroups="regression" -DthreadCount="5" -DTEST_ENVIRONMENT="qa"  -DREFRESH_TOKEN="YOUR_REFRESH_TOKEN"`
* Run test for different environment `mvn clean test -Dgroups="regression" -DthreadCount="5" -DTEST_ENVIRONMENT="uat"  -DREFRESH_TOKEN="YOUR_REFRESH_TOKEN"`

Framework Brief Details on tools and libraries utilized
=================================================
- Rest Assured for rest api handling with BDD
- TestNG as test framework 
- Java as programming language
- Allure Reports for Test results report
- Hamcrest for optimizing POJO boilerplate codes
- Jackson API for Serialization and De-Serialization
- Lombok for optimizing POJO boilerplate codes
- IntelliJ as IDE
- GitHub for Version control
- Jenkins (Compatible) for CI CD

Framework capabilities and it's implementation details
=========================================
- Easily Scalable and extensible
- Reusable Rest Assured specifications
- Reusable Rest Assured API components
- Separation of API layer from test layer
- POJOs for Serialization and Deserialization
- Singleton Design Pattern for properties loading
- Lombok for reducing Boilerplate code
- Builder pattern for Setter methods in POJOs
- Robust reporting and logging using Allure Reports
- Supports parallel execution
- Automated access token renewal
- Supports Maven command line execution and runtime parameters of environment, test filtering via groups and other necessary params
- Supports integration with GitHub
- Supports integration with Jenkins, Github Actions (YAML present in the repo)

