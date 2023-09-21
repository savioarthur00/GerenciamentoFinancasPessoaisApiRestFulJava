package FinancaPessoal.Api.repository;

import java.util.List;

import FinancaPessoal.Api.model.Transaction;

public interface TransactionRepository {
	
	Transaction findById(Long id);
	
	void save (Transaction transaction);
	
	void delete (Transaction transaction);
	
	List<Transaction> findAll();

}
