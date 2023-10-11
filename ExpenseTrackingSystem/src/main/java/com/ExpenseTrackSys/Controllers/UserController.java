package com.ExpenseTrackSys.Controllers;

import java.util.HashMap; 
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTrackSys.DTO.LoginDTO;
import com.ExpenseTrackSys.Entities.User;
import com.ExpenseTrackSys.Services.UserService;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	
	//Enter only userID and Password to login.
	//This mapping with Post request verify that the user is registered or not!!
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> login(@RequestBody LoginDTO loginDTO)
	{
		Map<String,Object> map=new HashMap<>();
		try {
			String status = userService.checkCreds(loginDTO);
			map.put("message",status);
			map.put("SUCCESS",true);	
		}catch (Exception e) {
			map.put("SUCCESS",false);
			map.put("exception",e);
		}
		return ResponseEntity.ok(map);
	}
	
	//Enter Only UserName and Password To Register.
	//This mapping with Post request register a new User.
	
	@PostMapping("/register")
    public ResponseEntity<User> Register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.SaveUser(user));
    }
	
	//This mapping with get request fetch a Single User based on ID provided in url.
	@GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
	
	
	

}
