package com.expense.tracker.service;

import com.expense.tracker.model.Budget;
import com.expense.tracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Add or update a budget
    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Get all budgets for a month/year
    public List<Budget> getBudgetsForMonth(int month, int year) {
        return budgetRepository.findByMonthAndYear(month, year);
    }

    // Get total budget for month/year
    public Double getTotalBudget(int month, int year) {
        return budgetRepository.getTotalBudgetForMonth(month, year);
    }

    // Delete a budget
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    // Delete all budgets for a month/year
    public void deleteBudgetsForMonth(int month, int year) {
        budgetRepository.deleteByMonthAndYear(month, year);
    }
}
