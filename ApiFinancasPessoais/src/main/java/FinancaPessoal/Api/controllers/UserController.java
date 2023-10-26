package FinancaPessoal.Api.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinancaPessoal.Api.model.User;
import FinancaPessoal.Api.repository.UserRepository;
import FinancaPessoal.Api.service.UserService;




@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse( code = 200, message = "Operation successful")
    })
	public void postUser(@RequestBody User user) {
			userService.save(user);
				
	}	

	@DeleteMapping("/{id}")
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse( code = 200, message = "Operation successful")
    })
	public void deleteUser(@PathVariable("id") Integer id) {
		 userService.deleteById(id);
	}
	
	@GetMapping
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse( code = 200, message = "Operation successful")
    })
    public List<User> getAll(){
        return (List<User>) userService.findAll();
    }
	

    @GetMapping("/{id}")
    @io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse( code = 200, message = "Operation successful"),
			@io.swagger.annotations.ApiResponse( code = 400, message = "User not found")
    })
   
    public Optional<User> getOneUser(@PathVariable("id") Integer id){
        return userService.findById(id);
    }
	
           
    @PutMapping("/{id}")
	public void putUser(@PathVariable("id") Integer id ,@RequestBody User user) {
    	if(userService.findById(id) !=null) {
			userService.save(user);
			
    	}
    }
	

	

}
