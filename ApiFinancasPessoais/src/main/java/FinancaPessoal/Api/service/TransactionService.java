package FinancaPessoal.Api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.Transaction;

@Service
public interface TransactionService {
			
	Transaction findById(Long id);
	
	void save(Transaction transaction);
	
	void put(Long id, Transaction transaction);
	
	void remove(Integer id);
	
	List<Transaction> findAll();
	

}
