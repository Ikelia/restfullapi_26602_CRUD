# Complete CRUD Operations Summary

This document provides a clear overview of all CRUD operations implemented in each API.

## CRUD Operations Explained

- **C**reate: POST - Add new resources
- **R**ead: GET - Retrieve resources
- **U**pdate: PUT/PATCH - Modify existing resources
- **D**elete: DELETE - Remove resources

---

## Question 1: Library Book Management API

### ✅ Complete CRUD Implementation

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/books` | Add a new book |
| **READ** | GET | `/api/books` | Get all books |
| **READ** | GET | `/api/books/{id}` | Get book by ID |
| **UPDATE** | PUT | `/api/books/{id}` | Update book details |
| **DELETE** | DELETE | `/api/books/{id}` | Delete a book |

**Additional Features:**
- Search by title: `GET /api/books/search?title={title}`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/books/1
Content-Type: application/json

{
  "title": "Clean Code - Updated Edition",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "publicationYear": 2020
}
```

---

## Question 2: Student Registration API

### ✅ Complete CRUD Implementation

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/students` | Register new student |
| **READ** | GET | `/api/students` | Get all students |
| **READ** | GET | `/api/students/{studentId}` | Get student by ID |
| **UPDATE** | PUT | `/api/students/{studentId}` | Update student info |
| **DELETE** | DELETE | `/api/students/{studentId}` | Delete student |

**Additional Features:**
- Filter by major: `GET /api/students/major/{major}`
- Filter by GPA: `GET /api/students/filter?gpa={minGpa}`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/students/1
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe.updated@email.com",
  "major": "Computer Science",
  "gpa": 3.95
}
```

**Example DELETE Request:**
```
DELETE http://localhost:8080/api/students/3
Expected: 204 NO CONTENT
```

---

## Question 3: Restaurant Menu API

### ✅ Complete CRUD Implementation

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/menu` | Add new menu item |
| **READ** | GET | `/api/menu` | Get all menu items |
| **READ** | GET | `/api/menu/{id}` | Get menu item by ID |
| **UPDATE** | PUT | `/api/menu/{id}` | Update menu item |
| **DELETE** | DELETE | `/api/menu/{id}` | Delete menu item |

**Additional Features:**
- Filter by category: `GET /api/menu/category/{category}`
- Filter by availability: `GET /api/menu/available?available=true`
- Search by name: `GET /api/menu/search?name={name}`
- Toggle availability: `PUT /api/menu/{id}/availability`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/menu/1
Content-Type: application/json

{
  "name": "Caesar Salad Deluxe",
  "description": "Fresh romaine lettuce with premium Caesar dressing and croutons",
  "price": 10.99,
  "category": "Appetizer",
  "available": true
}
```

**Example DELETE Request:**
```
DELETE http://localhost:8080/api/menu/8
Expected: 204 NO CONTENT
```

---

## Question 4: E-Commerce Product API

### ✅ Complete CRUD Implementation

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/products` | Add new product |
| **READ** | GET | `/api/products` | Get all products |
| **READ** | GET | `/api/products/{productId}` | Get product by ID |
| **UPDATE** | PUT | `/api/products/{productId}` | Update product |
| **DELETE** | DELETE | `/api/products/{productId}` | Delete product |

**Additional Features:**
- Pagination: `GET /api/products?page={page}&limit={limit}`
- Filter by category: `GET /api/products/category/{category}`
- Filter by brand: `GET /api/products/brand/{brand}`
- Search: `GET /api/products/search?keyword={keyword}`
- Price range: `GET /api/products/price-range?min={min}&max={max}`
- In-stock only: `GET /api/products/in-stock`
- Update stock: `PATCH /api/products/{productId}/stock?quantity={qty}`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/products/1
Content-Type: application/json

{
  "name": "iPhone 15 Pro",
  "description": "Latest Apple smartphone with A17 chip",
  "price": 1099.99,
  "category": "Electronics",
  "stockQuantity": 75,
  "brand": "Apple"
}
```

**Example DELETE Request:**
```
DELETE http://localhost:8080/api/products/6
Expected: 204 NO CONTENT
```

---

## Question 5: Task Management API

### ✅ Complete CRUD Implementation

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/tasks` | Create new task |
| **READ** | GET | `/api/tasks` | Get all tasks |
| **READ** | GET | `/api/tasks/{taskId}` | Get task by ID |
| **UPDATE** | PUT | `/api/tasks/{taskId}` | Update task |
| **DELETE** | DELETE | `/api/tasks/{taskId}` | Delete task |

**Additional Features:**
- Filter by status: `GET /api/tasks/status?completed={true/false}`
- Filter by priority: `GET /api/tasks/priority/{priority}`
- Mark complete: `PATCH /api/tasks/{taskId}/complete`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/tasks/1
Content-Type: application/json

{
  "title": "Complete project documentation - UPDATED",
  "description": "Write comprehensive API documentation with examples",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2026-02-28"
}
```

**Example DELETE Request:**
```
DELETE http://localhost:8080/api/tasks/5
Expected: 204 NO CONTENT
```

---

## Bonus: User Profile API

### ✅ Complete CRUD Implementation (with ApiResponse wrapper)

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| **CREATE** | POST | `/api/users` | Create user profile |
| **READ** | GET | `/api/users` | Get all users |
| **READ** | GET | `/api/users/{userId}` | Get user by ID |
| **UPDATE** | PUT | `/api/users/{userId}` | Update user profile |
| **DELETE** | DELETE | `/api/users/{userId}` | Delete user |

**Additional Features:**
- Search by username: `GET /api/users/search/username?username={name}`
- Search by country: `GET /api/users/search/country?country={country}`
- Search by age: `GET /api/users/search/age-range?min={min}&max={max}`
- Activate: `PATCH /api/users/{userId}/activate`
- Deactivate: `PATCH /api/users/{userId}/deactivate`

**Example UPDATE Request:**
```json
PUT http://localhost:8080/api/users/1
Content-Type: application/json

{
  "username": "john_doe_updated",
  "email": "john.updated@email.com",
  "fullName": "John Doe Jr.",
  "age": 29,
  "country": "USA",
  "bio": "Senior Software Developer",
  "active": true
}
```

**Example UPDATE Response (with ApiResponse):**
```json
{
  "success": true,
  "message": "User profile updated successfully",
  "data": {
    "userId": 1,
    "username": "john_doe_updated",
    "email": "john.updated@email.com",
    "fullName": "John Doe Jr.",
    "age": 29,
    "country": "USA",
    "bio": "Senior Software Developer",
    "active": true
  }
}
```

**Example DELETE Request:**
```
DELETE http://localhost:8080/api/users/3
Expected: 200 OK with ApiResponse
```

---

## Complete CRUD Testing Workflow

For each API, follow this testing sequence:

### 1. READ - Get All Resources
```
GET http://localhost:8080/api/{resource}
```
Verify initial data is loaded.

### 2. CREATE - Add New Resource
```
POST http://localhost:8080/api/{resource}
Content-Type: application/json

{ ... resource data ... }
```
Verify: 201 CREATED status, new ID assigned.

### 3. READ - Get Specific Resource
```
GET http://localhost:8080/api/{resource}/{id}
```
Verify: 200 OK, correct data returned.

### 4. UPDATE - Modify Resource
```
PUT http://localhost:8080/api/{resource}/{id}
Content-Type: application/json

{ ... updated data ... }
```
Verify: 200 OK, changes applied.

### 5. READ - Verify Update
```
GET http://localhost:8080/api/{resource}/{id}
```
Verify: Updated data is returned.

### 6. DELETE - Remove Resource
```
DELETE http://localhost:8080/api/{resource}/{id}
```
Verify: 204 NO CONTENT (or 200 OK for User API).

### 7. READ - Verify Deletion
```
GET http://localhost:8080/api/{resource}/{id}
```
Verify: 404 NOT FOUND.

---

## HTTP Status Codes Reference

| Code | Meaning | When Used |
|------|---------|-----------|
| 200 | OK | Successful GET, PUT, PATCH |
| 201 | Created | Successful POST (resource created) |
| 204 | No Content | Successful DELETE (no body returned) |
| 404 | Not Found | Resource doesn't exist |

---

## Summary

✅ **All 6 APIs have complete CRUD operations**
✅ **Proper HTTP methods and status codes**
✅ **Additional search and filter features**
✅ **Consistent API design patterns**
✅ **Ready for production testing**

Test each API using Postman, curl, or any REST client following the examples above!
