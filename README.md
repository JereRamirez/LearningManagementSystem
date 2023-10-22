# Learning Management System

The Learning Management System (LMS) is a Java-based web application designed to manage student enrollments in courses, track student logs, and facilitate course management for administrators. This README provides an overview of the application, instructions on how to run it, and details on testing the system.

## Features

### Functionality

1. **Student Registration:**
  - Students can self-register by providing basic demographic information and contact details.
  - Business rules include age verification, preventing duplicate registrations with the same email, and requiring mandatory information such as first name, last name, date of birth, address, email, and phone number.

2. **Course Management (Administrator):**
  - Administrators can create and manage courses.
  - Business rules include ensuring course names are unique, restricting course management to administrators, and setting a maximum course duration of 6 months.

3. **Student Enrollment:**
  - Students can enroll in courses with a limit of no more than three courses per student.
  - Enrollment validates that a student is not already enrolled in the same course.

4. **Student Logs:**
  - Students can log hours spent on tasks.
  - Log includes the date, task category (e.g., researching, practicing, watching videos), task description, and time spent in 30-minute increments.
  - Students can update and delete logs as needed.

## Prerequisites

- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- An integrated development environment (IDE) like IntelliJ IDEA or Eclipse
- An SQL database (e.g., MySQL or H2 for development/testing)

## How to Run

1. Clone this repository to your local machine:

git clone https://github.com/JereRamirez/LearningManagementSystem.git


2. Open the project in your preferred IDE.

3. Configure your database connection in the `application.properties` file.

4. Build and run the application.

## How to Test

The application includes unit tests and integration tests to ensure proper functionality. To run the tests, follow these steps:

1. Open the project in your IDE.

2. Locate the test classes under the `src/test` directory.

3. Right-click on the test classes and run them using your IDE's testing tools.


