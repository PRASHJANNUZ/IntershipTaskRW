package com.ExpenseTrackSys.Services;

import java.util.List;
import java.util.Optional;

import com.ExpenseTrackSys.Entities.Expense;

public interface ExpenseService {


	//here we can defined our Service methods as per the requirements
	
	List<Expense> getAllExpenses();

	Optional<Expense> getExpenseById(int id);

	Expense addExpense(Expense expense);

	boolean deleteExpense(int id);

	Expense updateExpense2(Expense expense);
	
	
}
