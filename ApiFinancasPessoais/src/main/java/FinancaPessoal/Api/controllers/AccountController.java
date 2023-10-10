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
import FinancaPessoal.Api.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping
	public void postAccount(@RequestBody Account account) {
		accountRepository.save(account);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAccount(@PathVariable("id") Integer id) {
		accountRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
    public Account getOneUser(@PathVariable("id") Long id){
        return accountRepository.findById(id);
    }
	
	@PutMapping
    public void atualizarAccount(@RequestBody Account account){
		accountRepository.save(account);
    }
	
	
	
	
}
