# 🎤 ExpenseIQ - Quick Demo Cheat Sheet

## 🚀 Start Server (Do this FIRST)
```bash
cd C:\Users\LOKESH\Downloads\files
run.bat
```
OR use Spring Boot Dashboard in VS Code

---

## 📱 Demo Flow (Follow this order)

### 1️⃣ Dashboard (30 sec)
- URL: http://localhost:8080/
- Point to: Summary cards (Income, Expense, Balance)
- Say: "Real-time financial overview"

---

### 2️⃣ Add Income (1 min)
1. Click **"Add Entry"** tab
2. Select: 💚 **Income**
3. Enter:
   - Amount: `50000`
   - Category: `Salary`
   - Date: Today
   - Description: `Monthly Salary`
4. Click **"Add Entry"**
5. ✅ Verify: Green toast notification
6. Go back to **Dashboard** - show balance updated

---

### 3️⃣ Add Expenses (2 min)
1. Click **"Add Entry"** tab
2. Select: ❤️ **Expense**
3. Add these 3 expenses:

| Amount | Category | Description |
|--------|----------|-------------|
| 5000 | Rent | Monthly Rent |
| 1200 | Food | Groceries |
| 800 | Travel | Bus Pass |

4. After EACH expense, go to **Dashboard** to show balance changing

---

### 4️⃣ Budget Feature (2 min) ⭐ KEY FEATURE
1. Click **"Budget"** tab
2. Set these budgets:
   - Category: `Food` → Amount: `5000` → Click **"Set Budget"**
   - Category: `Travel` → Amount: `2000` → Click **"Set Budget"**
   - Category: `Shopping` → Amount: `3000` → Click **"Set Budget"**
3. Click **"View Status"**
4. Point out:
   - ✓ **On Track** (green) = Under budget
   - ⚠️ **Exceeded** (red) = Over budget
   - Progress bars

---

### 5️⃣ Monthly Report (1 min)
1. Click **"Monthly"** tab
2. Select: Current month (April) and year (2026)
3. Click **"View Report"**
4. Say: "Filter transactions by any month"

---

### 6️⃣ Charts (1 min) 📊
1. Click **"Charts"** tab
2. Point to:
   - **Bar Chart**: Income vs Expense over time
   - **Pie Chart**: Where money is going (expense categories)
3. Say: "Visual insights for better financial decisions"

---

## 💬 Key Phrases to Say

| Feature | Say This |
|---------|----------|
| Dashboard | "Real-time financial health at a glance" |
| Add Entry | "Categorize every transaction for better tracking" |
| Budget | "Set limits and get alerts when you overspend" |
| Charts | "Visual patterns help identify spending habits" |
| Overall | "From data entry to insights in 3 clicks" |

---

## ⌨️ Keyboard Shortcuts

| Action | Shortcut |
|--------|----------|
| Refresh page | F5 |
| Zoom in (for visibility) | Ctrl + |
| Zoom out | Ctrl - |
| Open DevTools | F12 |
| New tab | Ctrl + T |

---

## 🆘 Emergency Fixes

| Problem | Quick Fix |
|---------|-----------|
| Server won't start | Check MySQL is running |
| Port 8080 busy | Kill process: `taskkill /F /PID 14456` |
| White screen | Check browser console (F12) |
| Data not saving | Verify DB password in application.properties |
| Charts blank | Add more expense data first |

---

## 📞 API Quick Test (if needed)

Open PowerShell and run:
```powershell
# Test API
Invoke-RestMethod http://localhost:8080/api/expenses/summary

# Add expense via API
$body = @{amount=100; type='EXPENSE'; category='Food'; date='2026-04-01'} | ConvertTo-Json
Invoke-RestMethod http://localhost:8080/api/expenses -Method Post -Body $body -ContentType 'application/json'
```

---

## ✅ Pre-Presentation Checklist

- [ ] MySQL running
- [ ] Server started (green "Started ExpenseTrackerApplication" message)
- [ ] Browser open to http://localhost:8080/
- [ ] No errors in browser console (F12)
- [ ] Practice run completed
- [ ] Water bottle nearby 😄

---

## 🎯 5-Minute Demo Script

> "Hi, I'm presenting **ExpenseIQ** - a personal finance tracker.
> 
> **(Click Dashboard)** This is my financial dashboard - income, expenses, and balance in real-time.
> 
> **(Add Income)** Let me add my salary of 50,000 rupees... ✓ Added!
> 
> **(Add Expenses)** Now my expenses - rent 5000, food 1200, travel 800...
> 
> **(Back to Dashboard)** See how the balance updated automatically?
> 
> **(Budget tab)** Here's the cool part - I set budgets per category. Food: 5000, Travel: 2000. The system tracks if I'm overspending.
> 
> **(Charts tab)** And finally, visual charts show my spending patterns.
> 
> This helps me make smarter financial decisions. Thank you!"

---

**You've got this! Good luck! 🎉**
