package com.ExpenseTrackSys.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTrackSys.Entities.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

	//if we want to implement any custom methods or query write here
	
}
