-- ============================================
-- Insert Sample Data
-- ============================================
-- Run this script to populate tables with initial data

-- ============================================
-- Sample Books
-- ============================================
INSERT INTO books (title, author, isbn, publication_year) VALUES
('Clean Code', 'Robert Martin', '978-0132350884', 2008),
('Effective Java', 'Joshua Bloch', '978-0134685991', 2017),
('Design Patterns', 'Gang of Four', '978-0201633610', 1994);

-- ============================================
-- Sample Students
-- ============================================
INSERT INTO students (first_name, last_name, email, major, gpa) VALUES
('John', 'Doe', 'john.doe@email.com', 'Computer Science', 3.8),
('Jane', 'Smith', 'jane.smith@email.com', 'Computer Science', 3.9),
('Mike', 'Johnson', 'mike.j@email.com', 'Business', 3.2),
('Sarah', 'Williams', 'sarah.w@email.com', 'Engineering', 3.6),
('Tom', 'Brown', 'tom.b@email.com', 'Computer Science', 3.4);

-- ============================================
-- Sample Menu Items
-- ============================================
INSERT INTO menu_items (name, description, price, category, available) VALUES
('Caesar Salad', 'Fresh romaine lettuce with Caesar dressing', 8.99, 'Appetizer', TRUE),
('Garlic Bread', 'Toasted bread with garlic butter', 5.99, 'Appetizer', TRUE),
('Grilled Salmon', 'Atlantic salmon with lemon butter sauce', 24.99, 'Main Course', TRUE),
('Beef Steak', 'Premium ribeye steak with vegetables', 32.99, 'Main Course', FALSE),
('Pasta Carbonara', 'Creamy pasta with bacon', 16.99, 'Main Course', TRUE),
('Chocolate Cake', 'Rich chocolate layer cake', 7.99, 'Dessert', TRUE),
('Tiramisu', 'Classic Italian dessert', 8.99, 'Dessert', TRUE),
('Fresh Lemonade', 'Homemade lemonade', 3.99, 'Beverage', TRUE);

-- ============================================
-- Sample Products
-- ============================================
INSERT INTO products (name, description, price, category, stock_quantity, brand) VALUES
('iPhone 14', 'Latest Apple smartphone', 999.99, 'Electronics', 50, 'Apple'),
('Samsung Galaxy S23', 'Android flagship phone', 899.99, 'Electronics', 30, 'Samsung'),
('MacBook Pro', 'Professional laptop', 2499.99, 'Electronics', 20, 'Apple'),
('Nike Air Max', 'Running shoes', 129.99, 'Footwear', 100, 'Nike'),
('Adidas Ultraboost', 'Comfortable running shoes', 149.99, 'Footwear', 75, 'Adidas'),
('Sony Headphones', 'Noise cancelling headphones', 299.99, 'Electronics', 0, 'Sony'),
('Levi''s Jeans', 'Classic denim jeans', 79.99, 'Clothing', 200, 'Levi''s'),
('Canon Camera', 'DSLR camera', 1299.99, 'Electronics', 15, 'Canon'),
('Nike T-Shirt', 'Cotton sports t-shirt', 29.99, 'Clothing', 150, 'Nike'),
('Apple Watch', 'Smartwatch', 399.99, 'Electronics', 40, 'Apple');

-- ============================================
-- Sample Tasks
-- ============================================
INSERT INTO tasks (title, description, completed, priority, due_date) VALUES
('Complete project documentation', 'Write comprehensive API documentation', FALSE, 'HIGH', '2026-02-25'),
('Code review', 'Review pull requests from team', FALSE, 'MEDIUM', '2026-02-20'),
('Fix login bug', 'Resolve authentication issue', TRUE, 'HIGH', '2026-02-18'),
('Update dependencies', 'Update npm packages', FALSE, 'LOW', '2026-03-01'),
('Team meeting', 'Weekly standup meeting', TRUE, 'MEDIUM', '2026-02-17');

-- ============================================
-- Sample User Profiles
-- ============================================
INSERT INTO user_profiles (username, email, full_name, age, country, bio, active) VALUES
('john_doe', 'john@email.com', 'John Doe', 28, 'USA', 'Software developer', TRUE),
('jane_smith', 'jane@email.com', 'Jane Smith', 25, 'Canada', 'Designer', TRUE),
('mike_wilson', 'mike@email.com', 'Mike Wilson', 35, 'UK', 'Project manager', FALSE),
('sarah_jones', 'sarah@email.com', 'Sarah Jones', 30, 'USA', 'Data analyst', TRUE),
('tom_brown', 'tom@email.com', 'Tom Brown', 22, 'Australia', 'Student', TRUE);

-- ============================================
-- Verify Data Insertion
-- ============================================
DO $$
DECLARE
    book_count INTEGER;
    student_count INTEGER;
    menu_count INTEGER;
    product_count INTEGER;
    task_count INTEGER;
    user_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO book_count FROM books;
    SELECT COUNT(*) INTO student_count FROM students;
    SELECT COUNT(*) INTO menu_count FROM menu_items;
    SELECT COUNT(*) INTO product_count FROM products;
    SELECT COUNT(*) INTO task_count FROM tasks;
    SELECT COUNT(*) INTO user_count FROM user_profiles;
    
    RAISE NOTICE 'Data insertion completed!';
    RAISE NOTICE 'Books: %', book_count;
    RAISE NOTICE 'Students: %', student_count;
    RAISE NOTICE 'Menu Items: %', menu_count;
    RAISE NOTICE 'Products: %', product_count;
    RAISE NOTICE 'Tasks: %', task_count;
    RAISE NOTICE 'User Profiles: %', user_count;
END $$;
