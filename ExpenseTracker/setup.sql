-- ============================================
-- Expense Tracker - MySQL Setup Script
-- Run this before starting the application
-- ============================================

-- Create database
CREATE DATABASE IF NOT EXISTS expense_tracker_db;
USE expense_tracker_db;

-- The table is auto-created by Spring Boot (ddl-auto=update)
-- But you can also create it manually:

CREATE TABLE IF NOT EXISTS expense (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount   DOUBLE       NOT NULL,
    type     VARCHAR(20)  NOT NULL COMMENT 'INCOME or EXPENSE',
    category VARCHAR(50),
    description VARCHAR(255),
    date     DATE         NOT NULL
);

-- Sample data
INSERT INTO expense (amount, type, category, description, date) VALUES
(50000, 'INCOME',  'Salary',      'Monthly salary',       '2026-03-01'),
(1200,  'EXPENSE', 'Food',        'Groceries',            '2026-03-05'),
(800,   'EXPENSE', 'Travel',      'Bus pass',             '2026-03-07'),
(5000,  'EXPENSE', 'Rent',        'Monthly rent',         '2026-03-10'),
(300,   'EXPENSE', 'Utilities',   'Electricity bill',     '2026-03-15'),
(2000,  'INCOME',  'Freelance',   'Web design project',   '2026-03-20'),
(600,   'EXPENSE', 'Food',        'Restaurant outing',    '2026-03-22'),
(50000, 'INCOME',  'Salary',      'Monthly salary',       '2026-04-01'),
(1500,  'EXPENSE', 'Food',        'Monthly groceries',    '2026-04-03'),
(900,   'EXPENSE', 'Travel',      'Petrol',               '2026-04-05'),
(5000,  'EXPENSE', 'Rent',        'Monthly rent',         '2026-04-10'),
(400,   'EXPENSE', 'Utilities',   'Water + Internet',     '2026-04-12');

SELECT 'Database setup complete!' AS Status;
USE expense_tracker_db;                                                                                                                                                                                                                    │
  INSERT INTO expense (amount, type, category, description, date) VALUES                                                 
  (50000, 'INCOME', 'Salary', 'March Salary', '2026-03-01'),                                                             
  (50000, 'INCOME', 'Salary', 'April Salary', '2026-04-01'),                                                             
  (5000, 'EXPENSE', 'Rent', 'March Rent', '2026-03-05'),                                                                 
  (5000, 'EXPENSE', 'Rent', 'April Rent', '2026-04-05'),                                                                 
  (2000, 'EXPENSE', 'Food', 'Groceries', '2026-03-10'),                                                                  
  (1500, 'EXPENSE', 'Food', 'Groceries', '2026-04-10'),                                                                  
  (800, 'EXPENSE', 'Travel', 'Bus Pass', '2026-03-15'),                                                                  
  (500, 'EXPENSE', 'Travel', 'Petrol', '2026-04-12'),                                                                    
  (3000, 'EXPENSE', 'Shopping', 'Clothes', '2026-03-20'),                                                                
  (2500, 'EXPENSE', 'Entertainment', 'Movie & Dinner', '2026-04-15'); 