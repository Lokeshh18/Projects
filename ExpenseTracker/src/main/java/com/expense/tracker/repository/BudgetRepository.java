package com.expense.tracker.repository;

import com.expense.tracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    // Find all budgets for a specific month and year
    @Query("SELECT b FROM Budget b WHERE b.month = :month AND b.year = :year ORDER BY b.category")
    List<Budget> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

    // Find budget for a specific category in a month/year
    Optional<Budget> findByCategoryAndMonthAndYear(String category, int month, int year);

    // Total budget for month/year
    @Query("SELECT COALESCE(SUM(b.amount), 0) FROM Budget b WHERE b.month = :month AND b.year = :year")
    Double getTotalBudgetForMonth(@Param("month") int month, @Param("year") int year);

    // Delete all for month/year
    void deleteByMonthAndYear(int month, int year);
}
