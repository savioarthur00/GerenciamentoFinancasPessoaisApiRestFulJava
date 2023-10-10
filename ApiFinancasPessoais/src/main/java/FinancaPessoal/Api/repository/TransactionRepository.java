package FinancaPessoal.Api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import FinancaPessoal.Api.model.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {
	
	Optional<Transaction> findById(Integer id);
	
	Transaction save (Transaction transaction);
	
	void deleteById (Transaction transaction);
	
	 List<Transaction> findAll();

	

}
