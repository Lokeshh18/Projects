package com.expense.tracker.service;

import com.expense.tracker.model.Budget;
import com.expense.tracker.model.Expense;
import com.expense.tracker.repository.BudgetRepository;
import com.expense.tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    // Add a new income or expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Get all records
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Update
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        existing.setAmount(updatedExpense.getAmount());
        existing.setType(updatedExpense.getType());
        existing.setCategory(updatedExpense.getCategory());
        existing.setDescription(updatedExpense.getDescription());
        existing.setDate(updatedExpense.getDate());
        return expenseRepository.save(existing);
    }

    // Delete
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Summary: total income, total expense, balance
    public Map<String, Double> getSummary() {
        Double totalIncome = expenseRepository.getTotalIncome();
        Double totalExpense = expenseRepository.getTotalExpense();
        Double balance = totalIncome - totalExpense;

        Map<String, Double> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpense", totalExpense);
        summary.put("balance", balance);
        return summary;
    }

    // Monthly report
    public List<Expense> getMonthlyReport(int month, int year) {
        return expenseRepository.findByMonthAndYear(month, year);
    }

    // Monthly chart data
    public List<Map<String, Object>> getMonthlySummaryData() {
        List<Object[]> raw = expenseRepository.getMonthlySummary();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] row : raw) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("month", row[0]);
            entry.put("year", row[1]);
            entry.put("type", row[2]);
            entry.put("total", row[3]);
            result.add(entry);
        }
        return result;
    }

    // Check if expenses exceed budget for a category
    public Map<String, Object> checkBudgetStatus(int month, int year) {
        List<Budget> budgets = budgetRepository.findByMonthAndYear(month, year);
        Map<String, Object> status = new HashMap<>();
        List<Map<String, Object>> categoryStatus = new ArrayList<>();

        for (Budget budget : budgets) {
            Map<String, Object> catData = new HashMap<>();
            catData.put("category", budget.getCategory());
            catData.put("budgetAmount", budget.getAmount());
            
            // Get actual expenses for this category
            Double actual = expenseRepository.getExpensesByCategoryAndMonth(budget.getCategory(), month, year);
            catData.put("actualAmount", actual != null ? actual : 0);
            catData.put("remaining", budget.getAmount() - (actual != null ? actual : 0));
            catData.put("exceeded", actual != null && actual > budget.getAmount());
            
            categoryStatus.add(catData);
        }

        status.put("categories", categoryStatus);
        status.put("month", month);
        status.put("year", year);
        return status;
    }
}
