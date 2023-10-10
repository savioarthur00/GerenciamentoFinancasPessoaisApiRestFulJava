package FinancaPessoal.Api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.Transaction;

@Service
public interface TransactionService {
			
	Optional<Transaction> findById(Integer id);
	
	void save(Transaction transaction);
			
	void removeById(Integer id);
	
	List<Transaction> findAll();
	

}
