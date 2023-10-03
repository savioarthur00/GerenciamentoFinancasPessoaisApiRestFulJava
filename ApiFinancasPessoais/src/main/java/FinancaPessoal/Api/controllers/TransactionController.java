package FinancaPessoal.Api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinancaPessoal.Api.model.Transaction;
import FinancaPessoal.Api.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public void postAccount(@RequestBody Transaction transaction) {
		transactionService.save(transaction);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		transactionService.remove(id);
	}
	
	@GetMapping("/{id}")
    public Transaction getOneUser(@PathVariable("id") Long id){
        return transactionService.findById(id);
    }
	
	@GetMapping()
    public List<Transaction> getOneUser(){
        return transactionService.findAll();
    }
	
	
	@PutMapping
    public void atualizarAccount(@RequestBody Transaction transaction){
		transactionService.put(transaction.getId(), transaction);
    }
	
}
