# 🎬 Series Quotes API

![Java](https://img.shields.io/badge/Java-21-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Backend](https://img.shields.io/badge/Backend-Java-success)
![REST](https://img.shields.io/badge/REST-API-lightgrey)
![Swagger](https://img.shields.io/badge/OpenAPI-Swagger-green)
![License](https://img.shields.io/badge/License-MIT-green)

**Series Quotes API** is a RESTful backend application built with **Spring Boot** that provides, stores, and manages famous quotes from TV series characters.

This project was developed for **learning and portfolio purposes**, focusing on clean architecture, REST principles, proper HTTP usage, global exception handling, and API documentation with Swagger (OpenAPI).

---

## 🚀 Features

- 🎲 Retrieve a random quote
- 🔍 Get a quote by ID
- 📚 List all registered quotes
- ➕ Create new quotes
- 🗑️ Delete quotes by ID
- 📦 DTO-based API design
- 🔄 Centralized mapping layer
- ⚠️ Global exception handling
- 📖 Interactive API documentation with Swagger

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- Swagger / OpenAPI (springdoc)
- Maven
- PostgreSQL (environment-based)

---

## 📁 Project Structure

```text
br.com.seriesquotes
├── config
│   └── CorsConfiguration      # CORS configuration to allow frontend or external clients to access the API
├── controller
│   ├── SeriesQuotesController # REST controller that exposes all quote-related HTTP endpoints
│   └── dto
│       └── QuotesDTO          # Data Transfer Object used to send and receive data through the API
├── domain.entity
│   └── Quote                  # JPA entity that represents the quotes table in the database
├── exception
│   ├── GlobalExceptionHandler # Centralized exception handling using @RestControllerAdvice
│   └── dto
│       └── ApiError           # Standard error response returned by the API
├── mapper
│   └── SeriesQuotesMapper     # Responsible for converting Entity ↔ DTO, keeping controllers and services clean
├── repository
│   └── SeriesQuotesRepository # Spring Data JPA repository used to interact with the database
├── service
│   └── SeriesQuotesService    # Business layer that contains application logic and rules
└── SeriesQuotesApplication
```

---

## 🌐 API Endpoints

**Base path:**
```
/quotes
```

### 🎲 Get a random quote
```
GET /quotes/random
```

### 🔍 Get quote by ID
```
GET /quotes/{id}
```

### 📚 Get all quotes
```
GET /quotes/all
```

### ➕ Create a new quote
```
POST /quotes
```

### 🗑️ Delete quote by ID
```
DELETE /quotes/{id}
```

---

## 📖 Swagger Documentation

The Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Configuration (application.yml)

The project uses **YAML** configuration.
You must provide your own database credentials.

```code
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/music_catalog
    username: YOUR_DB_USERNAME
    password: YOUR_DB_PASSWORD
```
--- 

## ▶️ Running the Project

### Prerequisites

* Java 17 or higher
* Maven
* PostgreSQL

### Steps

#### 1. Clone the repository:

```bash
git clone https://github.com/leonardobe/series-quotes-api.git
```

#### 2. Create the database:

```sql
CREATE DATABASE series_quotes;
```

#### 3. Configure application.yml
Set your PostgreSQL credentials.

#### 4. Run the application

```bash
mvn spring-boot:run
```
---

## 📄 License

This project is licensed under the **MIT License**.

---

## 👨‍💻 Author

Developed by **Leonardo**.
Focused on Java back-end development, clean architecture, and continuous learning.
