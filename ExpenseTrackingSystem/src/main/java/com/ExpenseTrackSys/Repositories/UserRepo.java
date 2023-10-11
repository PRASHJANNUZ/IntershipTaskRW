package com.ExpenseTrackSys.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTrackSys.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	//if we want to implement any custom methods or query for user write here
}
