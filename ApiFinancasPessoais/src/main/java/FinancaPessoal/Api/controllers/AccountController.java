package FinancaPessoal.Api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinancaPessoal.Api.model.Account;
import FinancaPessoal.Api.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public void postAccount(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		accountService.remove(id);
	}
	
	@GetMapping("/{id}")
    public Account getOneUser(@PathVariable("id") Long id){
        return accountService.findById(id);
    }
	
	@PutMapping
    public void atualizarAccount(@RequestBody Account account){
        accountService.put(account.getId(), account);
    }
	
}
