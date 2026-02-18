# Quick CRUD Reference Card

## All CRUD Endpoints at a Glance

### 📚 Question 1: Books API - `/api/books`

```
CREATE  → POST   /api/books
READ    → GET    /api/books
READ    → GET    /api/books/{id}
UPDATE  → PUT    /api/books/{id}
DELETE  → DELETE /api/books/{id}
```

### 🎓 Question 2: Students API - `/api/students`

```
CREATE  → POST   /api/students
READ    → GET    /api/students
READ    → GET    /api/students/{studentId}
UPDATE  → PUT    /api/students/{studentId}
DELETE  → DELETE /api/students/{studentId}
```

### 🍽️ Question 3: Menu API - `/api/menu`

```
CREATE  → POST   /api/menu
READ    → GET    /api/menu
READ    → GET    /api/menu/{id}
UPDATE  → PUT    /api/menu/{id}
DELETE  → DELETE /api/menu/{id}
```

### 🛒 Question 4: Products API - `/api/products`

```
CREATE  → POST   /api/products
READ    → GET    /api/products
READ    → GET    /api/products/{productId}
UPDATE  → PUT    /api/products/{productId}
DELETE  → DELETE /api/products/{productId}
```

### ✅ Question 5: Tasks API - `/api/tasks`

```
CREATE  → POST   /api/tasks
READ    → GET    /api/tasks
READ    → GET    /api/tasks/{taskId}
UPDATE  → PUT    /api/tasks/{taskId}
DELETE  → DELETE /api/tasks/{taskId}
```

### 👤 Bonus: Users API - `/api/users`

```
CREATE  → POST   /api/users
READ    → GET    /api/users
READ    → GET    /api/users/{userId}
UPDATE  → PUT    /api/users/{userId}
DELETE  → DELETE /api/users/{userId}
```

---

## Sample CRUD Test Sequence (Books Example)

```bash
# 1. READ - Get all books
curl http://localhost:8080/api/books

# 2. CREATE - Add new book
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Test Book","author":"Test Author","isbn":"123","publicationYear":2024}'

# 3. READ - Get specific book (use ID from step 2)
curl http://localhost:8080/api/books/4

# 4. UPDATE - Modify book
curl -X PUT http://localhost:8080/api/books/4 \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Book","author":"Updated Author","isbn":"123","publicationYear":2024}'

# 5. DELETE - Remove book
curl -X DELETE http://localhost:8080/api/books/4
```

---

## Expected Status Codes

| Operation | Success Code | Not Found Code |
|-----------|--------------|----------------|
| CREATE (POST) | 201 Created | - |
| READ (GET) | 200 OK | 404 Not Found |
| UPDATE (PUT) | 200 OK | 404 Not Found |
| DELETE | 204 No Content | 404 Not Found |

---

## Postman Quick Setup

1. Create new collection: "Spring Boot CRUD APIs"
2. Add 6 folders (one per question)
3. In each folder, add 5 requests:
   - GET All
   - GET By ID
   - POST Create
   - PUT Update
   - DELETE Remove
4. Set variable: `baseUrl = http://localhost:8080`

---

## Testing Checklist

For each API, verify:

- [ ] ✅ CREATE: POST creates new resource with 201 status
- [ ] ✅ READ All: GET returns all resources with 200 status
- [ ] ✅ READ One: GET by ID returns specific resource with 200 status
- [ ] ✅ READ One (Not Found): GET invalid ID returns 404 status
- [ ] ✅ UPDATE: PUT modifies resource with 200 status
- [ ] ✅ UPDATE (Not Found): PUT invalid ID returns 404 status
- [ ] ✅ DELETE: DELETE removes resource with 204 status
- [ ] ✅ DELETE (Not Found): DELETE invalid ID returns 404 status

---

## All APIs Running on Port 8080

Start application:
```bash
mvn spring-boot:run
```

Or on Windows:
```bash
mvnw.cmd spring-boot:run
```

Base URL: `http://localhost:8080`

---

## Complete CRUD Implementation ✅

All 6 APIs (5 questions + bonus) have full CRUD operations implemented!
