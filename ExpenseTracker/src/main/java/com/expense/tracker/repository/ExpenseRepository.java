package com.expense.tracker.repository;

import com.expense.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find all by type (INCOME or EXPENSE)
    List<Expense> findByType(String type);

    // Find by month and year
    @Query("SELECT e FROM Expense e WHERE MONTH(e.date) = :month AND YEAR(e.date) = :year ORDER BY e.date DESC")
    List<Expense> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

    // Total income
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.type = 'INCOME'")
    Double getTotalIncome();

    // Total expense
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.type = 'EXPENSE'")
    Double getTotalExpense();

    // Monthly summary grouped by month
    @Query("SELECT MONTH(e.date) as month, YEAR(e.date) as year, e.type, SUM(e.amount) as total " +
           "FROM Expense e GROUP BY YEAR(e.date), MONTH(e.date), e.type ORDER BY YEAR(e.date), MONTH(e.date)")
    List<Object[]> getMonthlySummary();

    // Get expenses by category and month
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.category = :category " +
           "AND MONTH(e.date) = :month AND YEAR(e.date) = :year AND e.type = 'EXPENSE'")
    Double getExpensesByCategoryAndMonth(@Param("category") String category, 
                                         @Param("month") int month, 
                                         @Param("year") int year);
}
