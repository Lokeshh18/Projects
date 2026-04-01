# 💰 ExpenseIQ - Personal Finance Tracker

A modern, full-stack web application for tracking personal income and expenses with budget management and visual insights.

![Dashboard](https://img.shields.io/badge/Status-Production%20Ready-success)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)

---

## ✨ Features

- 📊 **Real-time Dashboard** - View total income, expenses, and balance at a glance
- ➕ **Transaction Management** - Add, view, and delete income/expense entries
- 💰 **Budget Tracking** - Set monthly budgets per category and monitor spending
- 📅 **Monthly Reports** - Filter transactions by month and year
- 📈 **Interactive Charts** - Visualize spending patterns with bar and pie charts
- 🎨 **Modern UI** - Clean, dark-themed interface with responsive design
- ⚡ **Real-time Updates** - Dashboard refreshes automatically after each transaction

---

## 🛠️ Technology Stack

| Component | Technology |
|-----------|------------|
| Backend | Spring Boot 3.2.0 (Java 21) |
| Frontend | HTML5, CSS3, JavaScript |
| Database | MySQL 8 |
| Build Tool | Apache Maven |
| Charts | Chart.js |
| API | RESTful Web Services |

---

## 🚀 Quick Start

### Prerequisites

- Java 21 or higher
- MySQL 8
- Internet connection (for Maven dependencies)

### Installation

1. **Clone or download this project**
   ```bash
   cd C:\Users\LOKESH\Downloads\files
   ```

2. **Configure database**
   - Ensure MySQL is running
   - Update password in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.password=your_password
     ```

3. **Run the application**
   
   **Option A: Using the batch file (Easiest)**
   ```bash
   run.bat
   ```
   
   **Option B: Using Maven wrapper**
   ```bash
   .mvn\wrapper\apache-maven-3.9.6\bin\mvn.cmd spring-boot:run
   ```
   
   **Option C: Using Spring Boot Dashboard (VS Code)**
   - Open project in VS Code
   - Open Spring Boot Dashboard
   - Click "Run" on `ExpenseTrackerApplication`

4. **Access the application**
   - Frontend: http://localhost:8080/
   - API: http://localhost:8080/api/expenses

---

## 📁 Project Structure

```
expense-tracker/
├── src/main/
│   ├── java/com/expense/tracker/
│   │   ├── controller/
│   │   │   ├── ExpenseController.java
│   │   │   ├── BudgetController.java
│   │   │   └── HomeController.java
│   │   ├── service/
│   │   │   ├── ExpenseService.java
│   │   │   └── BudgetService.java
│   │   ├── repository/
│   │   │   ├── ExpenseRepository.java
│   │   │   └── BudgetRepository.java
│   │   ├── model/
│   │   │   ├── Expense.java
│   │   │   └── Budget.java
│   │   └── ExpenseTrackerApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           └── index.html
├── pom.xml
├── run.bat
└── README.md
```

---

## 📊 API Endpoints

### Expense Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/expenses` | Add new income/expense |
| GET | `/api/expenses` | Get all transactions |
| GET | `/api/expenses/{id}` | Get transaction by ID |
| PUT | `/api/expenses/{id}` | Update transaction |
| DELETE | `/api/expenses/{id}` | Delete transaction |
| GET | `/api/expenses/summary` | Get total income/expense/balance |
| GET | `/api/expenses/monthly?month=4&year=2026` | Get monthly report |
| GET | `/api/expenses/budget-status?month=4&year=2026` | Check budget vs actual |
| GET | `/api/expenses/chart-data` | Get data for charts |

### Budget Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/budgets` | Set a budget |
| GET | `/api/budgets?month=4&year=2026` | Get budgets for month |
| GET | `/api/budgets/total?month=4&year=2026` | Get total budget |
| DELETE | `/api/budgets/{id}` | Delete a budget |
| DELETE | `/api/budgets?month=4&year=2026` | Delete all budgets for month |

---

## 📝 Sample Usage

### Add an Expense (via API)

```bash
curl -X POST http://localhost:8080/api/expenses \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 5000,
    "type": "EXPENSE",
    "category": "Rent",
    "description": "Monthly Rent",
    "date": "2026-04-01"
  }'
```

### Add Income (via API)

```bash
curl -X POST http://localhost:8080/api/expenses \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 50000,
    "type": "INCOME",
    "category": "Salary",
    "description": "Monthly Salary",
    "date": "2026-04-01"
  }'
```

### Get Summary

```bash
curl http://localhost:8080/api/expenses/summary
```

Response:
```json
{
  "totalIncome": 50000.0,
  "totalExpense": 5000.0,
  "balance": 45000.0
}
```

---

## 🗄️ Database Setup

The database is created automatically when the application starts. However, you can manually set it up:

```bash
mysql -u root -p < setup.sql
```

---

## 🎯 Key Features Explained

### 1. Dashboard
Real-time overview of your financial health with three key metrics:
- **Total Income**: All money coming in
- **Total Expense**: All money going out
- **Net Balance**: Income - Expenses

### 2. Transaction Management
- Add income or expenses with categories
- View all transactions in a sortable table
- Delete unwanted entries
- Filter by month/year

### 3. Budget Tracking
- Set monthly budgets for each category
- Visual progress bars show spending vs budget
- Red alert when budget is exceeded
- Track remaining amount

### 4. Charts & Analytics
- **Bar Chart**: Income vs Expense comparison over months
- **Pie Chart**: Expense breakdown by category
- Interactive legends (click to filter)

---

## 🔧 Configuration

Edit `src/main/resources/application.properties`:

```properties
# Server
server.port=8080

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=root
spring.datasource.password=your_password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Testing

Test the API endpoints:

```bash
# Get all expenses
powershell -Command "Invoke-RestMethod http://localhost:8080/api/expenses"

# Get summary
powershell -Command "Invoke-RestMethod http://localhost:8080/api/expenses/summary"

# Get monthly report
powershell -Command "Invoke-RestMethod 'http://localhost:8080/api/expenses/monthly?month=4&year=2026'"
```

---

## 📚 Documentation Files

- `PRESENTATION_GUIDE.md` - Complete presentation script
- `DEMO_CHEAT_SHEET.md` - Quick reference for demos
- `README.md` - This file (project overview)

---

## 🤝 Contributing

This is a demonstration project. Feel free to:
1. Fork the repository
2. Add new features (recurring transactions, multi-user support, etc.)
3. Improve the UI/UX
4. Add export functionality (CSV/PDF)

---

## 📝 License

This project is created for educational/demonstration purposes.

---

## 👨‍💻 Developer

Built with ❤️ using Spring Boot

---

## 🆘 Troubleshooting

| Issue | Solution |
|-------|----------|
| Port 8080 already in use | Kill the process or change port in application.properties |
| MySQL connection error | Check MySQL service is running and password is correct |
| White screen | Check browser console for errors, ensure API is running |
| Build errors | Ensure Java 21 is installed (`java -version`) |

---

## 🎓 Learning Outcomes

This project demonstrates:
- ✅ Full-stack development (Frontend + Backend + Database)
- ✅ RESTful API design
- ✅ Spring Boot framework
- ✅ JPA/Hibernate ORM
- ✅ Input validation
- ✅ Real-time UI updates
- ✅ Data visualization
- ✅ Budget management logic

---

**Happy Tracking! 💰📊**
