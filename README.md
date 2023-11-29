# Selenium Cucumber Test Automation Framework

This is a test automation framework for automated testing Created for Assesment  using Selenium, Cucumber, and TestNG.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)


## Features


- BDD-style test scenarios with Cucumber, TestNg and assertJ for validations.
- MultiBrowser Support
- Reusable page objects and step definitions.


## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Web browsers installed (e.g., Chrome, Firefox).
- IDE installed

### Installation

1. Clone this repository:

   ```shell
   git clone git@github.com:Satishkrish/SatishAssesementDB.git
   ```

### Install Project Dependencies

   ```shell
   mvn clean install
   ```

## Usage

To Change the Browser
Go to Source-> Test->resources->congig->config.properties and change the browser as per requirement

Run the tests, use the following command:

   ```shell
   1. To Run Smoke Suite use command : mvn clean test -DxmlFilePath=testngSmoke.xml
   2. To Run Sanity Suite use command : mvn clean test -DxmlFilePath=testngSanity.xml
   3. To Run Regression Suite use command : mvn clean test -DxmlFilePath=testngRegression.xml
   

   ```
## Project Structure

- `src/main/java`: Contains your  utility classes.
- `src/test/java`: Contains your pages,Runner ,factory and step definitions.
- `src/test/resources`: Contains Cucumber feature files and config properties.
- `target`: Contains generated test reports and other build artifacts.
