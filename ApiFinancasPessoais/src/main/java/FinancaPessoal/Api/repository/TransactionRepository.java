package FinancaPessoal.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import FinancaPessoal.Api.model.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {
	
	Transaction findById(Long id);
	
	Transaction save (Transaction transaction);
	
	void delete (Transaction transaction);
	
	 List<Transaction> findAll();

	

}
