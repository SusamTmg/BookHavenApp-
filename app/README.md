Book Haven App

Project Overview

Book Haven is an Android application developed as part of the NIT3213 Mobile Application Development unit at Victoria University. The app is designed with a user-centric approach focusing on aesthetic UI, ViewModel architecture, clean code practices, and testing. The core objective of this application is to demonstrate practical application of Android development principles using Kotlin, ViewModels, and Retrofit while maintaining professional development standards like Git versioning and unit testing.

This version of Book Haven currently includes a fully implemented login screen with ViewModel logic, API request handling, and unit test validation.

Key Features Implemented

1. Login Screen (UI Design)

Custom background image with stacked book theme

Rounded EditText fields for first name and student ID

Material Design styled login button

App title and subtitle included

Custom logo integration using ImageView within a circle background

2. ViewModel Logic

Implemented LoginViewModel.kt to handle login-related data and logic

Integrated isValidLogin() function to validate input fields for testing

Supports API call handling using Retrofit in loginUser() function

3. API Integration

Retrofit set up with a dummy API client and data classes (LoginRequest and LoginResponse)

Network response handling via callbacks (onResponse, onFailure)

4. Unit Testing

Unit tests implemented in LoginViewModelTest.kt

Tests check for:

Valid login input

Empty username

Invalid password format (missing prefix "s")

Used JUnit framework

5. Project Architecture & Libraries

MVVM Architecture

Koin for Dependency Injection

Retrofit for API communication

View Binding enabled for safer XML referencing

6. Git Version Control

Multiple meaningful commits have been made throughout the development process

Repository hosted publicly on GitHub

Includes commit history with descriptive messages (e.g., ViewModel added, Unit testing completed, UI enhancements, etc.)

7. README File

This file documents all implemented features, setup steps, and assessment alignment

Technologies Used

Programming Language: Kotlin

Build Tool: Gradle

UI Toolkit: Android XML, Material Design Components

Architecture: MVVM

Dependency Injection: Koin

Networking: Retrofit2 + GSON

Testing: JUnit

Version Control: Git & GitHub

Folder Structure Overview

├── api
│   └── RetrofitClient.kt
├── model
│   ├── LoginRequest.kt
│   ├── LoginResponse.kt
├── LoginActivity.kt
├── LoginViewModel.kt
├── LoginViewModelTest.kt
├── MyApplication.kt

Setup Instructions

Clone the GitHub repository:

git clone https://github.com/SusamTmg/BookHavenApp-.git

Open the project in Android Studio

Allow Gradle sync to complete

Run the app on emulator or physical device (API level 29+)

To run unit tests, right-click on LoginViewModelTest.kt and select "Run Tests"

Assessment Criteria Fulfilled

Criteria

Implemented

Login Screen UI

Yes

ViewModel Logic

Yes

Unit Testing (LoginViewModel)

Yes

Git Usage and Commit History

Yes

README File with Complete Documentation

Yes

Author

Name: SusamUnit: NIT3213 - Mobile Application DevelopmentInstitution: Victoria UniversityYear: 2025

