# API Testing Guide

This guide provides detailed testing scenarios for all API endpoints.

## Prerequisites

1. Start the application: `mvn spring-boot:run` or `mvnw.cmd spring-boot:run`
2. Application runs on: `http://localhost:8080`
3. Use Postman, curl, or browser for testing

---

## Question 1: Library Book Management API

### Test 1: Get All Books
```
GET http://localhost:8080/api/books
Expected: 200 OK, returns 3 books
```

### Test 2: Get Book by ID
```
GET http://localhost:8080/api/books/1
Expected: 200 OK, returns "Clean Code"

GET http://localhost:8080/api/books/999
Expected: 404 NOT FOUND
```

### Test 3: Search Books by Title
```
GET http://localhost:8080/api/books/search?title=clean
Expected: 200 OK, returns books with "clean" in title
```

### Test 4: Add New Book
```
POST http://localhost:8080/api/books
Content-Type: application/json

{
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "isbn": "978-1617292545",
  "publicationYear": 2016
}

Expected: 201 CREATED, returns book with id=4
```

### Test 5: Delete Book
```
DELETE http://localhost:8080/api/books/1
Expected: 204 NO CONTENT

DELETE http://localhost:8080/api/books/999
Expected: 404 NOT FOUND
```

---

## Question 2: Student Registration API

### Test 1: Get All Students
```
GET http://localhost:8080/api/students
Expected: 200 OK, returns 5 students
```

### Test 2: Get Students by Major
```
GET http://localhost:8080/api/students/major/Computer Science
Expected: 200 OK, returns 3 CS students (John, Jane, Tom)
```

### Test 3: Filter by GPA
```
GET http://localhost:8080/api/students/filter?gpa=3.5
Expected: 200 OK, returns students with GPA >= 3.5 (John: 3.8, Jane: 3.9, Sarah: 3.6)
```

### Test 4: Register New Student
```
POST http://localhost:8080/api/students
Content-Type: application/json

{
  "firstName": "Emily",
  "lastName": "Davis",
  "email": "emily.d@email.com",
  "major": "Mathematics",
  "gpa": 3.95
}

Expected: 201 CREATED
```

### Test 5: Update Student
```
PUT http://localhost:8080/api/students/1
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe.updated@email.com",
  "major": "Computer Science",
  "gpa": 3.9
}

Expected: 200 OK
```

---

## Question 3: Restaurant Menu API

### Test 1: Get All Menu Items
```
GET http://localhost:8080/api/menu
Expected: 200 OK, returns 8 menu items
```

### Test 2: Get Items by Category
```
GET http://localhost:8080/api/menu/category/Dessert
Expected: 200 OK, returns 2 desserts (Chocolate Cake, Tiramisu)

GET http://localhost:8080/api/menu/category/Main Course
Expected: 200 OK, returns 3 main courses
```

### Test 3: Get Available Items
```
GET http://localhost:8080/api/menu/available?available=true
Expected: 200 OK, returns 7 available items (Beef Steak is unavailable)
```

### Test 4: Search by Name
```
GET http://localhost:8080/api/menu/search?name=salad
Expected: 200 OK, returns Caesar Salad
```

### Test 5: Add Menu Item
```
POST http://localhost:8080/api/menu
Content-Type: application/json

{
  "name": "Chicken Wings",
  "description": "Spicy buffalo wings",
  "price": 9.99,
  "category": "Appetizer",
  "available": true
}

Expected: 201 CREATED
```

### Test 6: Toggle Availability
```
PUT http://localhost:8080/api/menu/4/availability
Expected: 200 OK, Beef Steak becomes available (true)

PUT http://localhost:8080/api/menu/4/availability
Expected: 200 OK, Beef Steak becomes unavailable (false)
```

---

## Question 4: E-Commerce Product API

### Test 1: Get All Products
```
GET http://localhost:8080/api/products
Expected: 200 OK, returns 10 products
```

### Test 2: Pagination
```
GET http://localhost:8080/api/products?page=0&limit=5
Expected: 200 OK, returns first 5 products

GET http://localhost:8080/api/products?page=1&limit=5
Expected: 200 OK, returns next 5 products
```

### Test 3: Get by Category
```
GET http://localhost:8080/api/products/category/Electronics
Expected: 200 OK, returns 6 electronic products
```

### Test 4: Get by Brand
```
GET http://localhost:8080/api/products/brand/Apple
Expected: 200 OK, returns 3 Apple products (iPhone, MacBook, Apple Watch)
```

### Test 5: Search by Keyword
```
GET http://localhost:8080/api/products/search?keyword=phone
Expected: 200 OK, returns iPhone, Samsung Galaxy, Sony Headphones
```

### Test 6: Price Range Filter
```
GET http://localhost:8080/api/products/price-range?min=100&max=500
Expected: 200 OK, returns products between $100-$500
```

### Test 7: In-Stock Products
```
GET http://localhost:8080/api/products/in-stock
Expected: 200 OK, returns 9 products (Sony Headphones has 0 stock)
```

### Test 8: Add Product
```
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "name": "HP Laptop",
  "description": "Business laptop",
  "price": 899.99,
  "category": "Electronics",
  "stockQuantity": 30,
  "brand": "HP"
}

Expected: 201 CREATED
```

### Test 9: Update Stock
```
PATCH http://localhost:8080/api/products/6/stock?quantity=50
Expected: 200 OK, Sony Headphones stock updated to 50
```

---

## Question 5: Task Management API

### Test 1: Get All Tasks
```
GET http://localhost:8080/api/tasks
Expected: 200 OK, returns 5 tasks
```

### Test 2: Filter by Completion Status
```
GET http://localhost:8080/api/tasks/status?completed=false
Expected: 200 OK, returns 3 incomplete tasks

GET http://localhost:8080/api/tasks/status?completed=true
Expected: 200 OK, returns 2 completed tasks
```

### Test 3: Get by Priority
```
GET http://localhost:8080/api/tasks/priority/HIGH
Expected: 200 OK, returns 2 high priority tasks
```

### Test 4: Create Task
```
POST http://localhost:8080/api/tasks
Content-Type: application/json

{
  "title": "Deploy to production",
  "description": "Deploy latest version",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2026-02-22"
}

Expected: 201 CREATED
```

### Test 5: Mark as Complete
```
PATCH http://localhost:8080/api/tasks/1/complete
Expected: 200 OK, task marked as completed
```

---

## Bonus: User Profile API

### Test 1: Get All Users (with ApiResponse)
```
GET http://localhost:8080/api/users
Expected: 200 OK
Response format:
{
  "success": true,
  "message": "Users retrieved successfully",
  "data": [...]
}
```

### Test 2: Search by Username
```
GET http://localhost:8080/api/users/search/username?username=john
Expected: 200 OK, returns john_doe
```

### Test 3: Search by Country
```
GET http://localhost:8080/api/users/search/country?country=USA
Expected: 200 OK, returns 2 users from USA
```

### Test 4: Search by Age Range
```
GET http://localhost:8080/api/users/search/age-range?min=25&max=30
Expected: 200 OK, returns users aged 25-30
```

### Test 5: Create User
```
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "username": "lisa_white",
  "email": "lisa@email.com",
  "fullName": "Lisa White",
  "age": 26,
  "country": "Canada",
  "bio": "Backend developer",
  "active": true
}

Expected: 201 CREATED with ApiResponse wrapper
```

### Test 6: Activate/Deactivate User
```
PATCH http://localhost:8080/api/users/3/activate
Expected: 200 OK, Mike Wilson activated

PATCH http://localhost:8080/api/users/3/deactivate
Expected: 200 OK, Mike Wilson deactivated
```

---

## Postman Collection

You can import these endpoints into Postman by creating a new collection with the following structure:

1. Create collection: "Spring Boot REST API Questions"
2. Add folders for each question
3. Add requests with the endpoints above
4. Set base URL variable: `{{baseUrl}}` = `http://localhost:8080`

---

## Common HTTP Status Codes Used

- **200 OK**: Successful GET, PUT, PATCH requests
- **201 CREATED**: Successful POST requests
- **204 NO CONTENT**: Successful DELETE requests
- **404 NOT FOUND**: Resource not found

---

## Tips for Testing

1. Test GET endpoints first to see initial data
2. Test POST to add new data
3. Test GET again to verify additions
4. Test PUT/PATCH to modify data
5. Test DELETE last
6. Always check HTTP status codes
7. Verify response body structure matches expected format
