# PostgreSQL Database Setup Guide

This guide will help you set up PostgreSQL database for the Spring Boot REST API project using pgAdmin.

## Prerequisites

- PostgreSQL installed on your system
- pgAdmin 4 installed
- PostgreSQL server running

## Step-by-Step Setup

### Step 1: Open pgAdmin

1. Launch pgAdmin 4
2. Connect to your PostgreSQL server (usually localhost)
3. Enter your PostgreSQL password when prompted

### Step 2: Create the Database

1. In pgAdmin, right-click on "Databases" in the left sidebar
2. Select "Create" → "Database..."
3. OR run the SQL script:

**Option A: Using pgAdmin UI**
- Database name: `spring_rest_api_db`
- Owner: `postgres`
- Click "Save"

**Option B: Using SQL Script**
1. Right-click on "Databases"
2. Select "Query Tool"
3. Open and run: `database/01_create_database.sql`

```sql
CREATE DATABASE spring_rest_api_db
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```

### Step 3: Connect to the New Database

1. In pgAdmin left sidebar, expand "Databases"
2. Find and click on `spring_rest_api_db`
3. Right-click on `spring_rest_api_db`
4. Select "Query Tool"

### Step 4: Create Tables

1. In the Query Tool, open the file: `database/02_create_tables.sql`
2. Click the "Execute" button (▶️) or press F5
3. You should see: "All tables created successfully!"

This will create 6 tables:
- `books` - Library book management
- `students` - Student registration
- `menu_items` - Restaurant menu
- `products` - E-commerce products
- `tasks` - Task management
- `user_profiles` - User profiles

### Step 5: Insert Sample Data

1. In the Query Tool, open the file: `database/03_insert_sample_data.sql`
2. Click the "Execute" button (▶️) or press F5
3. You should see data insertion confirmation with counts

This will insert:
- 3 books
- 5 students
- 8 menu items
- 10 products
- 5 tasks
- 5 user profiles

### Step 6: Verify Tables and Data

**View Tables:**
1. In pgAdmin, expand `spring_rest_api_db`
2. Expand "Schemas" → "public" → "Tables"
3. You should see all 6 tables

**View Data:**
1. Right-click on any table (e.g., `books`)
2. Select "View/Edit Data" → "All Rows"
3. Verify the sample data is present

**Or run queries:**
```sql
SELECT * FROM books;
SELECT * FROM students;
SELECT * FROM menu_items;
SELECT * FROM products;
SELECT * FROM tasks;
SELECT * FROM user_profiles;
```

### Step 7: Configure Spring Boot Connection

The application is already configured to connect to PostgreSQL.

**File:** `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/spring_rest_api_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

**⚠️ IMPORTANT:** Update the password if your PostgreSQL password is different!

### Step 8: Run the Spring Boot Application

```bash
mvn spring-boot:run
```

Or on Windows:
```bash
mvnw.cmd spring-boot:run
```

The application will:
- Connect to PostgreSQL database
- Use existing tables (ddl-auto=update)
- Start on http://localhost:8080

---

## Database Schema Overview

### Table: books
| Column | Type | Constraints |
|--------|------|-------------|
| id | BIGSERIAL | PRIMARY KEY |
| title | VARCHAR(255) | NOT NULL |
| author | VARCHAR(255) | NOT NULL |
| isbn | VARCHAR(50) | NOT NULL |
| publication_year | INTEGER | NOT NULL |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

### Table: students
| Column | Type | Constraints |
|--------|------|-------------|
| student_id | BIGSERIAL | PRIMARY KEY |
| first_name | VARCHAR(100) | NOT NULL |
| last_name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(255) | NOT NULL, UNIQUE |
| major | VARCHAR(100) | NOT NULL |
| gpa | DECIMAL(3,2) | NOT NULL, CHECK (0.0-4.0) |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

### Table: menu_items
| Column | Type | Constraints |
|--------|------|-------------|
| id | BIGSERIAL | PRIMARY KEY |
| name | VARCHAR(255) | NOT NULL |
| description | TEXT | |
| price | DECIMAL(10,2) | NOT NULL, CHECK (>= 0) |
| category | VARCHAR(50) | NOT NULL |
| available | BOOLEAN | DEFAULT TRUE |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

### Table: products
| Column | Type | Constraints |
|--------|------|-------------|
| product_id | BIGSERIAL | PRIMARY KEY |
| name | VARCHAR(255) | NOT NULL |
| description | TEXT | |
| price | DECIMAL(10,2) | NOT NULL, CHECK (>= 0) |
| category | VARCHAR(100) | NOT NULL |
| stock_quantity | INTEGER | NOT NULL, CHECK (>= 0) |
| brand | VARCHAR(100) | NOT NULL |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

### Table: tasks
| Column | Type | Constraints |
|--------|------|-------------|
| task_id | BIGSERIAL | PRIMARY KEY |
| title | VARCHAR(255) | NOT NULL |
| description | TEXT | |
| completed | BOOLEAN | DEFAULT FALSE |
| priority | VARCHAR(20) | NOT NULL, CHECK (LOW/MEDIUM/HIGH) |
| due_date | DATE | |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

### Table: user_profiles
| Column | Type | Constraints |
|--------|------|-------------|
| user_id | BIGSERIAL | PRIMARY KEY |
| username | VARCHAR(100) | NOT NULL, UNIQUE |
| email | VARCHAR(255) | NOT NULL, UNIQUE |
| full_name | VARCHAR(255) | NOT NULL |
| age | INTEGER | NOT NULL, CHECK (0-150) |
| country | VARCHAR(100) | NOT NULL |
| bio | TEXT | |
| active | BOOLEAN | DEFAULT TRUE |
| created_at | TIMESTAMP | DEFAULT NOW |
| updated_at | TIMESTAMP | DEFAULT NOW |

---

## Troubleshooting

### Issue: Cannot connect to database

**Solution:**
1. Verify PostgreSQL is running
2. Check username/password in `application.properties`
3. Verify database name is correct: `spring_rest_api_db`

### Issue: Tables not created

**Solution:**
1. Make sure you're connected to `spring_rest_api_db` (not postgres database)
2. Run the `02_create_tables.sql` script again
3. Check for error messages in pgAdmin

### Issue: Sample data not inserted

**Solution:**
1. Make sure tables exist first
2. Run `03_insert_sample_data.sql` script
3. Check for constraint violations or errors

### Issue: Spring Boot cannot connect

**Solution:**
1. Verify PostgreSQL is running on port 5432
2. Update `application.properties` with correct credentials:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. Make sure PostgreSQL driver is in pom.xml

---

## Useful pgAdmin Queries

### Check all tables
```sql
SELECT table_name 
FROM information_schema.tables 
WHERE table_schema = 'public';
```

### Count records in all tables
```sql
SELECT 
    'books' as table_name, COUNT(*) as count FROM books
UNION ALL SELECT 'students', COUNT(*) FROM students
UNION ALL SELECT 'menu_items', COUNT(*) FROM menu_items
UNION ALL SELECT 'products', COUNT(*) FROM products
UNION ALL SELECT 'tasks', COUNT(*) FROM tasks
UNION ALL SELECT 'user_profiles', COUNT(*) FROM user_profiles;
```

### Drop all tables (if you need to start over)
```sql
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS menu_items CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS tasks CASCADE;
DROP TABLE IF EXISTS user_profiles CASCADE;
```

---

## Next Steps

1. ✅ Database created
2. ✅ Tables created
3. ✅ Sample data inserted
4. ✅ Spring Boot configured
5. 🚀 Run the application and test APIs!

All CRUD operations will now persist data to PostgreSQL instead of in-memory storage.
