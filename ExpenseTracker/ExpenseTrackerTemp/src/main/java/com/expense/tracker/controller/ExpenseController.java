package com.expense.tracker.controller;

import com.expense.tracker.model.Expense;
import com.expense.tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // POST /api/expenses — Add income or expense
    @PostMapping
    public ResponseEntity<?> addExpense(@Valid @RequestBody Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> 
                errors.put(err.getField(), err.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        Expense saved = expenseService.addExpense(expense);
        return ResponseEntity.ok(saved);
    }

    // GET /api/expenses — Get all records
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // GET /api/expenses/{id} — Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/expenses/{id} — Update
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.updateExpense(id, expense));
    }

    // DELETE /api/expenses/{id} — Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // GET /api/expenses/summary — Total income, expense, balance
    @GetMapping("/summary")
    public ResponseEntity<Map<String, Double>> getSummary() {
        return ResponseEntity.ok(expenseService.getSummary());
    }

    // GET /api/expenses/monthly?month=4&year=2026 — Monthly report
    @GetMapping("/monthly")
    public ResponseEntity<List<Expense>> getMonthlyReport(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(expenseService.getMonthlyReport(month, year));
    }

    // GET /api/expenses/chart-data — Data for JS chart
    @GetMapping("/chart-data")
    public ResponseEntity<List<Map<String, Object>>> getChartData() {
        return ResponseEntity.ok(expenseService.getMonthlySummaryData());
    }

    // GET /api/expenses/budget-status — Check budget vs actual spending
    @GetMapping("/budget-status")
    public ResponseEntity<Map<String, Object>> getBudgetStatus(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(expenseService.checkBudgetStatus(month, year));
    }
}
