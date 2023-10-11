package com.ExpenseTrackSys.ServicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseTrackSys.Entities.Expense;
import com.ExpenseTrackSys.Entities.User;
import com.ExpenseTrackSys.Repositories.ExpenseRepo;
import com.ExpenseTrackSys.Repositories.UserRepo;
import com.ExpenseTrackSys.Services.ExpenseService;

@Service
public class ExpenseServicesImpl implements ExpenseService {

	@Autowired
	private ExpenseRepo expenseRepo;
	@Autowired
	private UserRepo userRepo;
	
	//To get All Expenses
	@Override
	public List<Expense> getAllExpenses()
	{
		return expenseRepo.findAll();
	}
	
	//To Add Expenses
	@Override
	 public Expense addExpense(Expense expense) {
		User user = expense.getUser();
		if(Objects.nonNull(user)) {
			User uob = userRepo.findById(user.getId()).orElse(null);
			expense.setUser(uob);
		}	
		return expenseRepo.save(expense);
	        
	        
	    }

	//To get Expense by ID
	@Override
	public Optional<Expense> getExpenseById(int id) {
		// TODO Auto-generated method stub
		return expenseRepo.findById(id);
	}
	

	//To update Expense
	@Override
	 public Expense updateExpense2(Expense expense) {
		 
	        if(expenseRepo.existsById(expense.getId())) {
	            return expenseRepo.save(expense);
	        }else {
	        	return null;
	        }
	        
	    }
	
	 //To Delete the Expense
	 @Override
	 public boolean deleteExpense(int id) {
		 
	        if(expenseRepo.existsById(id))
	        {
	        	expenseRepo.deleteById(id);;
	            return true;
	        }
	        return false;
	    }
	
}
