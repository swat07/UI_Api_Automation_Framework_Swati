# 🧪 Test Strategy Document  
**Project:** UI_Api_Automation_Framework_Swati Test Strategy  
**Prepared By:** Swati 
**Date:** July 2025  

---

## ✅ 1. Objective

To verify the functional correctness of a full-stack web application built on the MERN stack using automated tests for both the React frontend and the Node.js backend API.

---

## ✅ 2. Scope of Testing

This strategy covers the following areas:

- **UI Functional Testing** using Selenium WebDriver:
  - Login with valid/invalid credentials
  - Create, edit, and delete a Todo item
  - Validation of UI messages and behavior after each action

- **API Testing** using REST-assured:
  - Login endpoint authentication
  - Full CRUD operations on Todo items via `/todos` endpoint
  - Positive and negative test cases

---

## ✅ 3. Tools and Frameworks

| Tool | Purpose | Justification |
|------|---------|----------------|
| **Selenium WebDriver** | UI Automation | Widely adopted, browser-based testing |
| **REST-assured** | API Testing | Easy to use for HTTP-based API validations |
| **TestNG** | Test Runner | Supports grouping, parallelism, and reporting |
| **Maven** | Build Tool | Dependency and lifecycle management |
| **ChromeDriver** | WebDriver executable | Required for browser automation |
| **GitHub Actions (Optional)** | CI/CD Pipeline | Integrate automated tests into CI workflows |

---

## ✅ 4. Test Coverage

### UI Tests (Selenium)

| Scenario                          | Coverage |
|----------------------------------|----------|
| Login with valid credentials     | ✅       |
| Login with invalid credentials   | ✅       |
| Create a new Todo item           | ✅       |
| Edit an existing Todo item       | ✅       |
| Delete a Todo item               | ✅       |
| UI assertions post actions       | ✅       |

### API Tests (REST-assured)

| Endpoint            | Method | Test Cases                  | Status |
|---------------------|--------|-----------------------------|--------|
| `/auth/login`       | POST   | Valid + Invalid login       | ✅     |
| `/todos`            | GET    | Authenticated fetch         | ✅     |
| `/todos`            | POST   | Create with valid/invalid   | ✅     |
| `/todos/:id`        | PUT    | Update valid/invalid ID     | ✅     |
| `/todos/:id`        | DELETE | Delete valid/invalid ID     | ✅     |

---

## ✅ 5. How to Run the Tests

### 🛠 Prerequisites:

- Chrome + ChromeDriver installed
- MongoDB running or using MongoDB Atlas
- Application (React + Node.js) running locally on:
  - Frontend: `http://localhost:3000`
  - Backend: `http://localhost:5000/api`

### 🧪 Execute Tests:

#### UI Tests:
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

#### API Tests (run with TestNG suite):
```bash
mvn test
```

---

## ✅ 6. Assumptions

- The backend must be running and seeded with a valid test user (`test@example.com / password123`)
- The UI locators used (IDs like `login-button`, `new-todo`, etc.) are stable
- Chrome is the default browser under test
- Auth tokens are assumed to be valid for API access during test execution

---

## ✅ 7. Limitations

- Cross-browser testing not covered (limited to Chrome)
- No performance, accessibility, or visual regression testing included
- No mocking/stubbing of backend APIs or DB
- No test data cleanup in DB (CRUD tests rely on order of execution)
- Test user credentials are hardcoded in config files