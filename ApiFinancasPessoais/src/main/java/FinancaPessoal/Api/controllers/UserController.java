package FinancaPessoal.Api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinancaPessoal.Api.model.User;
import FinancaPessoal.Api.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public void postUser(@RequestBody User user) {
	userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		 userService.remove(id);
	}
	
	@GetMapping
    public List<User> getAll(){
        return (List<User>) userService.findAll();
    }
	

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id){
        return userService.findById(id);
    }
	
    @PutMapping
    public void atualizarSocio(@RequestBody User user){
        userService.put(user.getId(), user);
    }
	

	

}
