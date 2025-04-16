# Book Haven App

## 📘 Project Overview

**Book Haven** is an Android application developed as part of the **NIT3213 Mobile Application Development** unit at Victoria University. It follows a user-centric approach, focusing on aesthetic UI, ViewModel architecture, clean code practices, and unit testing. The core objective is to demonstrate the practical application of Android development principles using **Kotlin**, **ViewModel**, and **Retrofit**, while maintaining professional practices like **Git versioning** and **testable architecture**.

This version of the app includes a fully implemented **login screen** with ViewModel logic, dummy API integration, and basic unit testing.

---

## ✅ Key Features Implemented

### 1. Login Screen (UI Design)
- Custom background image with stacked book theme
- Rounded `EditText` fields for **First Name** and **Student ID**
- Material Design styled **Login Button**
- App title and subtitle
- Custom logo using `ImageView` inside a circular background

### 2. ViewModel Logic
- Implemented `LoginViewModel.kt` to manage login logic and validation
- `isValidLogin()` function used for testable input validation
- Separated logic from UI for MVVM compliance

### 3. API Integration
- Retrofit configured with dummy API client
- Data classes: `LoginRequest.kt` and `LoginResponse.kt`
- Handled response using Retrofit callbacks (`onResponse`, `onFailure`)

### 4. Unit Testing
- Tests implemented in `LoginViewModelTest.kt` using JUnit
- Covered scenarios:
    - ✅ Valid input
    - ❌ Empty username
    - ❌ Password missing `"s"` prefix
- Unit testing validates logic without running the app

### 5. Project Architecture & Libraries
- MVVM architecture pattern
- Koin for Dependency Injection
- View Binding for safe and efficient XML referencing
- Modular and testable design

### 6. Git Version Control
- Multiple **meaningful commits** tracking each feature
- Hosted on [GitHub](https://github.com/SusamTmg/BookHavenApp-)
- Clean commit history with messages like:
    - `Add LoginViewModel logic`
    - `Implement unit testing`
    - `Polish UI styling`
    - 
### 7. README File
- This file includes:
    - Feature overview
    - Technologies used
    - Folder structure
    - Setup instructions
    - Assessment criteria checklist

## 💻 Technologies Used

| Area                | Tools & Frameworks                |
|---------------------|-----------------------------------|
| Language            | Kotlin                            |
| Build Tool          | Gradle                            |
| UI Toolkit          | Android XML, Material Design      |
| Architecture        | MVVM                              |
| Dependency Injection| Koin                              |
| Networking          | Retrofit2, GSON                   |
| Unit Testing        | JUnit                             |
| Version Control     | Git & GitHub                      |

---

## 📁 Folder Structure
├── api │ └── RetrofitClient.kt ├── model │ ├── LoginRequest.kt │ ├── LoginResponse.kt ├── LoginActivity.kt ├── LoginViewModel.kt ├── LoginViewModelTest.kt ├── MyApplication.kt



