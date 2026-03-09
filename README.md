# Fake-Store-API

API test automation suite for the **[Fake Store API](https://fakestoreapi.com/)** built with **Rest Assured** and **Java**. Covers end-to-end validation of a RESTful e-commerce API including products, carts, users, and authentication endpoints.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java | Core programming language |
| Rest Assured | API test automation |
| TestNG | Test execution and management |
| Maven | Build and dependency management |
| ExtentReports | HTML test reporting |

---

## API Under Test

**Base URL:** `https://fakestoreapi.com`

| Resource | Endpoint |
|----------|----------|
| Products | `/products` |
| Carts | `/carts` |
| Users | `/users` |
| Auth | `/auth/login` |

---

## Project Structure

```
Fake-Store-API/
├── src/
│   └── test/java/
│       ├── tests/
│       │   ├── ProductTests.java
│       │   ├── CartTests.java
│       │   ├── UserTests.java
│       │   └── AuthTests.java
│       └── utils/
│           └── BaseTest.java     # Base URL, headers, common setup
├── reports/                      # ExtentReports HTML output
├── testng.xml
└── pom.xml
```

---

## Test Coverage

### Products
- GET all products
- GET single product by ID
- GET products with limit and sort query params
- GET products by category
- POST create new product
- PUT update product
- DELETE product

### Carts
- GET all carts
- GET single cart
- GET carts in date range
- POST add to cart
- PUT update cart

### Users
- GET all users
- GET single user
- POST create user
- PUT update user

### Auth
- POST login with valid credentials - verify token returned
- POST login with invalid credentials - verify 401 response

---

## Assertions Used

- HTTP status code validation
- Response body field validation (JSON path assertions)
- Response time validation
- Schema validation
- Negative test cases (invalid IDs, wrong credentials)

---

## How to Run

### Prerequisites
- Java JDK 11+
- Maven 3.6+

### Steps

```bash
# Clone the repository
git clone https://github.com/Ranjini-V/Fake-Store-API.git
cd Fake-Store-API

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ProductTests
```

---

## Test Reports

After execution, find the report at:

```
reports/ExtentReport.html
```

---

## Concepts Demonstrated

- Rest Assured `given().when().then()` BDD syntax
- JSON path and GPath assertions
- Query parameter and path parameter handling
- Request/Response logging
- Reusable base test configuration
- Positive and negative test scenarios

---

## Author

**Ranjini V** - QA Automation Engineer  
[GitHub](https://github.com/Ranjini-V)
