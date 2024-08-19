# TestRepo

This project is an Android application that displays a list of GitHub repositories for a given organization. It allows users to browse and view repositories with details fetched directly from the GitHub API.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Testing](#testing)
- [Future Improvements](#future-improvements)

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

- Android Studio Koala | 2024.1.1 Patch 1 or later
- Gradle 8.9+
- Kotlin 1.9.25+
- JDK Oracle OpenJDK 19.0.1

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

## Future Improvements

### 1. Architecture Enhancements

In the future, the project architecture could be evolved into a feature module-based structure. This approach involves creating separate modules for each new feature while adhering to Clean Architecture principles. By isolating features into their own modules, we ensure better separation of concerns, improved scalability, and easier maintenance. Each feature module would encapsulate its own UI, business logic, and data layers, thus promoting reusability and reducing dependencies between different parts of the application.

### 2. Possible Features

To enhance the functionality and user experience of the application, the following features could be considered for future implementation:

- **Repository Details View**: Allow users to tap on a repository in the list and view detailed information about the repository, including description, stars, forks, and last updated date.
- **Search Functionality**: Implement a search bar that allows users to search for specific repositories by name or keywords, making it easier to find a particular repository in large lists.
- **Offline Support**: Introduce caching mechanisms to enable the application to display repositories even when the device is offline. This would involve saving the latest fetched data locally and updating it when the app regains internet connectivity.
