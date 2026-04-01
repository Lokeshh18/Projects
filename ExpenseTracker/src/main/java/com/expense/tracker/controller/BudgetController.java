package com.expense.tracker.controller;

import com.expense.tracker.model.Budget;
import com.expense.tracker.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin(origins = "*")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // POST /api/budgets — Add budget
    @PostMapping
    public ResponseEntity<?> addBudget(@Valid @RequestBody Budget budget, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> 
                errors.put(err.getField(), err.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(budgetService.addBudget(budget));
    }

    // GET /api/budgets — Get all budgets for month/year
    @GetMapping
    public ResponseEntity<List<Budget>> getBudgets(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(budgetService.getBudgetsForMonth(month, year));
    }

    // GET /api/budgets/total — Get total budget for month/year
    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalBudget(
            @RequestParam int month,
            @RequestParam int year) {
        Double total = budgetService.getTotalBudget(month, year);
        Map<String, Object> response = new HashMap<>();
        response.put("totalBudget", total);
        response.put("month", month);
        response.put("year", year);
        return ResponseEntity.ok(response);
    }

    // DELETE /api/budgets/{id} — Delete budget
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // DELETE /api/budgets — Delete all for month/year
    @DeleteMapping
    public ResponseEntity<String> deleteBudgetsForMonth(
            @RequestParam int month,
            @RequestParam int year) {
        budgetService.deleteBudgetsForMonth(month, year);
        return ResponseEntity.ok("Deleted all budgets for " + month + "/" + year);
    }
}
