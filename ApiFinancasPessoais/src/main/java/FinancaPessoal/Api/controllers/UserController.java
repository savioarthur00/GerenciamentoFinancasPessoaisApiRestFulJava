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
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userService;
	
	@PostMapping
	@ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
	public void postUser(@RequestBody User user) {
			userService.save(user);
				
	}	

	@DeleteMapping("/{id}")
	@ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
	public void deleteUser(@PathVariable("id") Integer id) {
		 userService.deleteById(id);
	}
	
	@GetMapping
	@ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public List<User> getAll(){
        return (List<User>) userService.findAll();
    }
	

    @GetMapping("/{id}")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
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
