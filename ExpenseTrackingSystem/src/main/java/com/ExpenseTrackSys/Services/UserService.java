package com.ExpenseTrackSys.Services;

import java.util.List;
import java.util.Optional;

import com.ExpenseTrackSys.DTO.LoginDTO;
import com.ExpenseTrackSys.Entities.User;

public interface UserService {

	public String checkCreds(LoginDTO LoginDTO);

	List<User> findAll();
	
	User SaveUser(User user);
	
	Optional<User> getUserById(int id);
}
