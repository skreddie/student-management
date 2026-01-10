---

## Student Management API

A clean Spring Boot REST API for managing student records with MySQL.

This project implements proper backend design patterns including DTO-based communication, validation, and centralized exception handling.

---

### Tech Stack

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA (Hibernate)
* MySQL Database
* Jakarta Bean Validation

---

### Features

* Create, read, update and delete student records
* `StudentRequestDTO` and `StudentResponseDTO` for clean API contracts
* Validation using `@Valid`, `@NotBlank`, and `@Email`
* Global exception handling using `@RestControllerAdvice`
* Uses correct HTTP status codes (201, 200, 400, 404)

---

### REST Endpoints

| Method | Endpoint         | Description      |
| ------ | ---------------- | ---------------- |
| POST   | `/students`      | Create a student |
| GET    | `/students`      | Retrieve all     |
| GET    | `/students/{id}` | Retrieve by ID   |
| PUT    | `/students/{id}` | Update student   |
| DELETE | `/students/{id}` | Delete student   |

---

### Sample Request

```
POST /students
{
  "name": "Amit",
  "email": "amit@example.com",
  "course": "Spring Boot"
}
```

---

### Error Handling

* 404 returned when a student ID does not exist
* 400 returned when request payload is invalid

Errors are returned consistently using a global exception handler.

---

### Upcoming Enhancements

* Flyway database migrations
* Swagger/OpenAPI documentation

---

Contributions welcome.
Star the repository if you find it helpful.

---
