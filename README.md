# TestRepo

This project is an Android application that displays a list of GitHub repositories for a given organization. It allows users to browse and view repositories with details fetched directly from the GitHub API.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Testing](#testing)

## Features

- Display a list of repositories for a specified GitHub organization.
- View repository details such as name, description, and other metadata.
- Modular, clean architecture following MVVM principles.
- Smooth UI using Jetpack Compose.
- Dependency injection with Hilt.
- Efficient network calls using Retrofit with OkHttp and Coroutines.

## Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel), Clean Architecture
- **UI**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Networking**: Retrofit + OkHttp
- **Concurrency**: Coroutines, Flow
- **Testing**:
    - Unit Testing: JUnit
    - Mocking: Mockk
    - Asynchronous Flow Testing: Turbine

## Project Structure

The project is structured as a multi-module Android project with the following modules:

- **app**: The main application module containing the UI and the entry point of the application.
- **core**: Contains common classes and utilities used across different modules.
- **data**: Responsible for data management, including API calls (Retrofit) and repository implementations.
- **domain**: Contains business logic, use cases, and repository interfaces.
- **presentation**: Manages the user interface layer of the application, including `ViewModel`s and `Composable` views, following the MVVM architecture pattern. This module is responsible for coordinating the display of data to the user and handling user interactions. 

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Gradle 8.9+
- Kotlin 1.9+

### Clone the Repository

```bash
git clone https://github.com/sergeykrupenich/TestRepo.git
cd TestRepo
```

## Testing

This project includes both unit and instrumental testing to ensure the reliability and correctness of the application’s features.

#### 1. **Domain Module Testing**
- **Unit Testing:**
  - The core business logic within the Domain module is thoroughly tested.
  - Several use cases and mappers are covered by unit tests to verify their functionality and correctness.

#### 2. **Presentation Layer Testing**
- **Unit Testing:**
  - The ViewModel, which handles the UI logic and state management, is tested to ensure it behaves as expected in different scenarios.
- **Instrumental Testing:**
  - UI components, specifically the EmptyState Compose view, are covered by instrumental UI tests. These tests verify that the UI elements render correctly and interact as intended.
