package com.expense.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private Double amount;

    // type: "INCOME" or "EXPENSE"
    @Column(nullable = false, length = 20)
    @NotNull(message = "Type is required")
    @Pattern(regexp = "^(INCOME|EXPENSE)$", message = "Type must be INCOME or EXPENSE")
    private String type;

    // category: Food, Travel, Salary, etc.
    @Column(length = 50)
    private String category;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Date is required")
    private LocalDate date;
}
