Contact-App to demonstrate BDD (Behavior Driven Development)
==============================

This app demonstrates BDD using Cucumber-JVM.

Technology Stack
-----------------
Please refer to

https://github.com/mmuduganti/contact-app/blob/master/service/build.gradle

https://github.com/mmuduganti/contact-app/blob/master/gradle.properties

Requirements to run this project
--------------------------------


Get started
-----------

1) To launch api tests use the below command

./gradlew apiTest -PcucumberFeature="features"

2) To access the application

./gradlew cRL

and the application can be accessed at http://localhost:8080/contact-service

3) To add a contact

POST to http://localhost:8080/contact-service/contact/save

sample json request:
```json
{
 "firstName":"maria",
 "lastName":"testcase",
 "phoneNum","123-456-7890"
}
```

4) To search a contact

GET to http://localhost:8080/contact-service/contact/search?firstName=<fname>