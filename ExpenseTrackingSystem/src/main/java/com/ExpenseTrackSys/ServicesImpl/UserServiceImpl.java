package com.ExpenseTrackSys.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseTrackSys.DTO.LoginDTO;
import com.ExpenseTrackSys.Entities.User;
import com.ExpenseTrackSys.Repositories.UserRepo;
import com.ExpenseTrackSys.Services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	// This method checks the user is Registered or not, before Login....
	
	@Override
	public String checkCreds(LoginDTO loginDTO) {
	     try {
	    	 User user = userRepo.findById(loginDTO.getId()).orElse(null);
	 		if(loginDTO.getId().equals(user.getId()) && loginDTO.getPassword().equals(user.getPassword())) {
	 			return "Log in sucessFully...!";
	 		}else {
	 			return "bad creds.......!";
	 		}
	     }catch (Exception e) {
	    	 return "Exception while checkCreds() method..";
		}
		
	}
	
	//To Save user
	
	@Override
	public User SaveUser(User user) {
		return userRepo.save(user);
	}

	
	//To get all Users
	
		@Override
		public List<User> findAll (){
			return userRepo.findAll();
		}

		//To Get User by ID

		@Override
		public Optional<User> getUserById(int id) {
			// TODO Auto-generated method stub
			
			return userRepo.findById(id);
		}
	
}
