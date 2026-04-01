# 💰 ExpenseIQ - Personal Finance Tracker

A modern, full-stack web application for tracking personal income and expenses with budget management and visual insights.

![Status](https://img.shields.io/badge/Status-Production%20Ready-success)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-Demo%20Available-blue)

---

## 🌐 Live Demo

**🎯 Demo Mode (GitHub Pages):** https://lokeshh18.github.io/Projects/

> ⚠️ **Note:** The GitHub Pages demo uses localStorage for data persistence. Data is stored only in your browser and will be lost if you clear browser data.

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

### Frontend (GitHub Pages)
| Component | Technology |
|-----------|------------|
| UI | HTML5, CSS3, JavaScript (Vanilla) |
| Charts | Chart.js |
| Storage | LocalStorage (Browser) |

### Full Stack (Spring Boot)
| Component | Technology |
|-----------|------------|
| Backend | Spring Boot 3.2.0 (Java 21) |
| Frontend | HTML5, CSS3, JavaScript |
| Database | MySQL 8 |
| Build Tool | Apache Maven |
| API | RESTful Web Services |

---

## 🚀 Quick Start

### Option 1: GitHub Pages Demo (Frontend Only)

1. Visit: **https://lokeshh18.github.io/Projects/**
2. Start tracking your expenses immediately
3. Data is stored in your browser (localStorage)

### Option 2: Local Spring Boot Application

#### Prerequisites
- Java 21 or higher
- MySQL 8
- Internet connection (for Maven dependencies)

#### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Lokeshh18/Projects.git
   cd Projects/ExpenseTracker
   ```

2. **Configure database**
   - Ensure MySQL is running
   - Update password in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.password=your_password
     ```

3. **Run the application**
   
   **Using Maven:**
   ```bash
   mvn spring-boot:run
   ```
   
   **Or use the included Maven wrapper:**
   ```bash
   .mvn/wrapper/apache-maven-3.9.6/bin/mvn.cmd spring-boot:run
   ```

4. **Access the application**
   - Frontend: http://localhost:8080/
   - API: http://localhost:8080/api/expenses

---

## 📁 Project Structure

```
Projects/
├── ExpenseTracker/              # Full-stack Spring Boot application
│   ├── src/main/
│   │   ├── java/com/expense/tracker/
│   │   │   ├── controller/
│   │   │   │   ├── ExpenseController.java
│   │   │   │   ├── BudgetController.java
│   │   │   │   └── HomeController.java
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── ExpenseTrackerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/index.html
│   └── pom.xml
│
├── docs/                        # GitHub Pages (Frontend Demo)
│   └── index.html
│
├── README.md                    # This file
└── PRESENTATION_GUIDE.md        # Presentation documentation
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
| GET | `/api/expenses/budget-status` | Check budget vs actual |

### Budget Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/budgets` | Set a budget |
| GET | `/api/budgets?month=4&year=2026` | Get budgets for month |
| DELETE | `/api/budgets/{id}` | Delete a budget |

---

## 📝 Sample Data

The GitHub Pages demo includes sample data to get you started:

**Income:**
- ₹50,000 - Salary (April 1)
- ₹2,000 - Freelance (April 15)

**Expenses:**
- ₹5,000 - Rent (April 5)
- ₹1,200 - Food (April 10)
- ₹800 - Travel (April 12)
- ₹500 - Food (April 18)

**Budgets:**
- ₹5,000 - Food
- ₹2,000 - Travel
- ₹3,000 - Shopping

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

## 🔧 Configuration (Spring Boot)

Edit `src/main/resources/application.properties`:

```properties
# Server
server.port=8080

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📚 Documentation

- [PRESENTATION_GUIDE.md](./PRESENTATION_GUIDE.md) - Complete presentation script
- [DEMO_CHEAT_SHEET.md](./DEMO_CHEAT_SHEET.md) - Quick reference for demos
- [SLIDES_OUTLINE.md](./SLIDES_OUTLINE.md) - PowerPoint slide outline

---

## 🤝 Contributing

Feel free to:
1. Fork the repository
2. Add new features (recurring transactions, multi-user support, etc.)
3. Improve the UI/UX
4. Add export functionality (CSV/PDF)

---

## 📝 License

This project is created for educational/demonstration purposes.

---

## 👨‍💻 Author

**Lokesh**

- GitHub: [@Lokeshh18](https://github.com/Lokeshh18)
- Project: [ExpenseIQ](https://github.com/Lokeshh18/Projects)

---

## 🆘 Troubleshooting

### GitHub Pages Demo
| Issue | Solution |
|-------|----------|
| Data not persisting | Check if localStorage is enabled in your browser |
| Charts not loading | Clear browser cache and refresh |
| Styles not applied | Hard refresh (Ctrl + Shift + R) |

### Spring Boot Application
| Issue | Solution |
|-------|----------|
| Port 8080 already in use | Kill the process or change port in application.properties |
| MySQL connection error | Check MySQL service is running and password is correct |
| Build errors | Ensure Java 21 is installed (`java -version`) |
| White screen | Check browser console for errors, ensure API is running |

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
- ✅ LocalStorage for client-side persistence
- ✅ GitHub Pages deployment

---

## 🚀 Deployment Options

### Frontend Only (Free)
- **GitHub Pages** - Current deployment
- **Netlify** - Drag & drop deployment
- **Vercel** - Automatic deployments from Git

### Full Stack (Free Tiers)
- **Render** - Spring Boot support with PostgreSQL
- **Railway** - Easy Spring Boot deployment
- **Heroku** - Java app hosting (paid)
- **AWS Elastic Beanstalk** - Free tier available

---

**Happy Tracking! 💰📊**
