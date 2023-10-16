package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entity.User;
import org.ncu.hirewheels.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public String listStudents(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllEmployees(){
		return userService.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<User>(userService.getUserById(employeeId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable long id
												  ,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		
		// delete employee from DB
		userService.deleteUser(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
}
