# Scale
This repository contains a Java-based automation framework using Cucumber for behavior-driven development (BDD). It's designed to find fake gold bar. 

## Getting Started

These instructions will help you set up and run the automated tests on your local machine.

## Prerequisites

To run the tests, you need to have the following software installed on your machine:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (Recommended: Java 8 or later)
- [Maven](https://maven.apache.org/download.cgi)
- [Chrome](https://www.google.com/chrome/) 

## Installation

1. Clone this repository to your local machine:

   git clone https://github.com/OleksandrSDET/Scale.git

2. Navigate to the project directory:

   cd Scale

3. Build the project using Maven:

  mvn clean install

## Running Tests

 You can run the automated tests using the following command:

  mvn test

The tests will be executed in the default browser (Chrome). You can customize the browser and other test settings by passing system properties.

## Test Reports
 Test reports are generated using Cucumber's built-in reporting. After running the tests, you can find the HTML test report at target/cucumber/index.html.

## Built With

Cucumber
Selenium
Maven
JUnit
