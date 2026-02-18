# Spring Boot RESTful API - Practice Questions

This project contains implementations for all 5 questions plus the bonus question from the Spring Boot REST API assignment.

## Project Structure

```
src/main/java/com/restapi/
├── RestApiApplication.java (Main application)
├── controller/
│   ├── library/BookController.java
│   ├── student/StudentController.java
│   ├── restaurant/MenuController.java
│   ├── ecommerce/ProductController.java
│   ├── task/TaskController.java
│   └── user/UserProfileController.java
└── model/
    ├── library/Book.java
    ├── student/Student.java
    ├── restaurant/MenuItem.java
    ├── ecommerce/Product.java
    ├── task/Task.java
    └── user/
        ├── UserProfile.java
        └── ApiResponse.java
```

## How to Run

1. Make sure you have Java 17 or higher installed
2. Navigate to the project directory
3. Run the application:
   ```
   mvn spring-boot:run
   ```
   Or on Windows:
   ```
   mvnw.cmd spring-boot:run
   ```
4. The application will start on `http://localhost:8080`

## API Endpoints

### Question 1: Library Book Management API

**Base URL:** `/api/books`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/books` | Get all books (READ) | 200 |
| GET | `/api/books/{id}` | Get book by ID (READ) | 200, 404 |
| GET | `/api/books/search?title={title}` | Search books by title | 200 |
| POST | `/api/books` | Add new book (CREATE) | 201 |
| PUT | `/api/books/{id}` | Update book (UPDATE) | 200, 404 |
| DELETE | `/api/books/{id}` | Delete book (DELETE) | 204, 404 |

**Sample Request (POST):**
```json
{
  "title": "Spring in Action",
  "author": "Craig Walls",
  "isbn": "978-1617294945",
  "publicationYear": 2018
}
```

**Sample Response (GET /api/books):**
```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert Martin",
    "isbn": "978-0132350884",
    "publicationYear": 2008
  }
]
```

---

### Question 2: Student Registration API

**Base URL:** `/api/students`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/students` | Get all students (READ) | 200 |
| GET | `/api/students/{studentId}` | Get student by ID (READ) | 200, 404 |
| GET | `/api/students/major/{major}` | Get students by major | 200 |
| GET | `/api/students/filter?gpa={minGpa}` | Filter by minimum GPA | 200 |
| POST | `/api/students` | Register new student (CREATE) | 201 |
| PUT | `/api/students/{studentId}` | Update student (UPDATE) | 200, 404 |
| DELETE | `/api/students/{studentId}` | Delete student (DELETE) | 204, 404 |

**Sample Request (POST):**
```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice.j@email.com",
  "major": "Computer Science",
  "gpa": 3.7
}
```

**Test Scenarios:**
- GET `/api/students/major/Computer Science` - Returns CS students
- GET `/api/students/filter?gpa=3.5` - Returns students with GPA >= 3.5

---

### Question 3: Restaurant Menu API

**Base URL:** `/api/menu`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/menu` | Get all menu items (READ) | 200 |
| GET | `/api/menu/{id}` | Get menu item by ID (READ) | 200, 404 |
| GET | `/api/menu/category/{category}` | Get items by category | 200 |
| GET | `/api/menu/available?available=true` | Get available items | 200 |
| GET | `/api/menu/search?name={name}` | Search by name | 200 |
| POST | `/api/menu` | Add new menu item (CREATE) | 201 |
| PUT | `/api/menu/{id}` | Update menu item (UPDATE) | 200, 404 |
| PUT | `/api/menu/{id}/availability` | Toggle availability | 200, 404 |
| DELETE | `/api/menu/{id}` | Remove menu item (DELETE) | 204, 404 |

**Sample Request (POST):**
```json
{
  "name": "Margherita Pizza",
  "description": "Classic Italian pizza",
  "price": 12.99,
  "category": "Main Course",
  "available": true
}
```

**Categories:** Appetizer, Main Course, Dessert, Beverage

---

### Question 4: E-Commerce Product API

**Base URL:** `/api/products`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/products` | Get all products (READ) | 200 |
| GET | `/api/products?page={page}&limit={limit}` | Get products with pagination | 200 |
| GET | `/api/products/{productId}` | Get product by ID (READ) | 200, 404 |
| GET | `/api/products/category/{category}` | Get by category | 200 |
| GET | `/api/products/brand/{brand}` | Get by brand | 200 |
| GET | `/api/products/search?keyword={keyword}` | Search products | 200 |
| GET | `/api/products/price-range?min={min}&max={max}` | Filter by price | 200 |
| GET | `/api/products/in-stock` | Get in-stock products | 200 |
| POST | `/api/products` | Add new product (CREATE) | 201 |
| PUT | `/api/products/{productId}` | Update product (UPDATE) | 200, 404 |
| PATCH | `/api/products/{productId}/stock?quantity={qty}` | Update stock | 200, 404 |
| DELETE | `/api/products/{productId}` | Delete product (DELETE) | 204, 404 |

**Sample Request (POST):**
```json
{
  "name": "Dell Laptop",
  "description": "High performance laptop",
  "price": 1299.99,
  "category": "Electronics",
  "stockQuantity": 25,
  "brand": "Dell"
}
```

**Test Examples:**
- GET `/api/products?page=0&limit=5` - First 5 products
- GET `/api/products/category/Electronics` - All electronics
- GET `/api/products/brand/Apple` - All Apple products
- GET `/api/products/search?keyword=phone` - Search for phones
- GET `/api/products/price-range?min=100&max=500` - Products $100-$500
- GET `/api/products/in-stock` - Available products

---

### Question 5: Task Management API

**Base URL:** `/api/tasks`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/tasks` | Get all tasks (READ) | 200 |
| GET | `/api/tasks/{taskId}` | Get task by ID (READ) | 200, 404 |
| GET | `/api/tasks/status?completed={true/false}` | Filter by status | 200 |
| GET | `/api/tasks/priority/{priority}` | Get by priority | 200 |
| POST | `/api/tasks` | Create new task (CREATE) | 201 |
| PUT | `/api/tasks/{taskId}` | Update task (UPDATE) | 200, 404 |
| PATCH | `/api/tasks/{taskId}/complete` | Mark as completed | 200, 404 |
| DELETE | `/api/tasks/{taskId}` | Delete task (DELETE) | 204, 404 |

**Sample Request (POST):**
```json
{
  "title": "Write unit tests",
  "description": "Add tests for all controllers",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2026-02-28"
}
```

**Priority Levels:** LOW, MEDIUM, HIGH

---

### Bonus: User Profile API

**Base URL:** `/api/users`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| GET | `/api/users` | Get all users (READ) | 200 |
| GET | `/api/users/{userId}` | Get user by ID (READ) | 200, 404 |
| GET | `/api/users/search/username?username={name}` | Search by username | 200 |
| GET | `/api/users/search/country?country={country}` | Search by country | 200 |
| GET | `/api/users/search/age-range?min={min}&max={max}` | Search by age | 200 |
| POST | `/api/users` | Create user profile (CREATE) | 201 |
| PUT | `/api/users/{userId}` | Update user profile (UPDATE) | 200, 404 |
| PATCH | `/api/users/{userId}/activate` | Activate profile | 200, 404 |
| PATCH | `/api/users/{userId}/deactivate` | Deactivate profile | 200, 404 |
| DELETE | `/api/users/{userId}` | Delete user (DELETE) | 200, 404 |

**Sample Request (POST):**
```json
{
  "username": "alex_smith",
  "email": "alex@email.com",
  "fullName": "Alex Smith",
  "age": 27,
  "country": "USA",
  "bio": "Full stack developer",
  "active": true
}
```

**Sample Response (with ApiResponse wrapper):**
```json
{
  "success": true,
  "message": "User profile created successfully",
  "data": {
    "userId": 6,
    "username": "alex_smith",
    "email": "alex@email.com",
    "fullName": "Alex Smith",
    "age": 27,
    "country": "USA",
    "bio": "Full stack developer",
    "active": true
  }
}
```

---

## Testing with Postman

1. Import the endpoints into Postman
2. Set base URL: `http://localhost:8080`
3. Test each endpoint with sample data
4. Verify HTTP status codes match expectations

### Quick Test Commands (using curl)

**Test Book API:**
```bash
curl http://localhost:8080/api/books
```

**Test Student API:**
```bash
curl http://localhost:8080/api/students/major/Computer%20Science
```

**Test Menu API:**
```bash
curl http://localhost:8080/api/menu/category/Dessert
```

**Test Product API:**
```bash
curl "http://localhost:8080/api/products/price-range?min=100&max=1000"
```

**Test Task API:**
```bash
curl "http://localhost:8080/api/tasks/status?completed=false"
```

**Test User API:**
```bash
curl http://localhost:8080/api/users
```

## Features Implemented

✅ **Complete CRUD Operations in ALL APIs**
- **C**reate: POST endpoints for adding new resources
- **R**ead: GET endpoints for retrieving resources (all and by ID)
- **U**pdate: PUT endpoints for modifying existing resources
- **D**elete: DELETE endpoints for removing resources

✅ All 5 main questions + bonus question
✅ Proper package structure (controller and model packages)
✅ Appropriate HTTP methods (GET, POST, PUT, PATCH, DELETE)
✅ Correct HTTP status codes (200, 201, 204, 404)
✅ @PathVariable for URL parameters
✅ @RequestParam for query parameters
✅ @RequestBody for POST/PUT requests
✅ Sample data initialization
✅ Search and filter functionality
✅ ApiResponse wrapper for bonus question

## Additional Documentation

- **README.md** - Complete API documentation with all endpoints
- **CRUD_SUMMARY.md** - Detailed CRUD operations for each API with examples
- **QUICK_REFERENCE.md** - Quick reference card for all CRUD endpoints
- **TESTING_GUIDE.md** - Comprehensive testing scenarios and examples

## Notes

- All data is stored in-memory using ArrayList
- No database or service layer (as per requirements)
- Sample data is initialized in each controller constructor
- IDs are auto-generated using a counter
- All endpoints return proper HTTP status codes
