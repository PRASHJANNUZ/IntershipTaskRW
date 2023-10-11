package com.ExpenseTrackSys.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTrackSys.Entities.Expense;
import com.ExpenseTrackSys.Entities.User;
import com.ExpenseTrackSys.Services.ExpenseService;
import com.ExpenseTrackSys.Services.UserService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private UserService userService;
	
	// This mapping with get request fetch all the Expenses of all login users
	
	@GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
	
	// This mapping with get request fetch only the one Expense based on id provided in url
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable int id) {
	        return ResponseEntity.ok(expenseService.getExpenseById(id));
	    }
	
	 // This mapping with Post request Adds the new Expenses with userID. so that we have provide the login user id While Adding a new Expense
	 
	 @PostMapping
	    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(expense));
	    }
	 
	 // This mapping with Put request updates the Existing Expense, we have to provide ExpenseID in @RequestBody to update with new Expense.
	 
	 @PutMapping
	    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
		 
	        return ResponseEntity.ok(expenseService.updateExpense2(expense));
	    }
	 
	 //This mapping with Delete request, delete the expenses of id provided in url.
	 
	 @DeleteMapping("/{id}")
	    public String deleteExpense(@PathVariable int id) {
	        if (expenseService.deleteExpense(id)) {
	            return "Expense deleted successfully";
	        }
	        return "Expense not found";
	    }
	 
	 //This Mapping with get request fetch all login users with all Expenses.
	 @GetMapping("/getAllusers")
	    public ResponseEntity<List<User>> getAllusers() {
	        return ResponseEntity.ok(userService.findAll());
	    }
	 
}
