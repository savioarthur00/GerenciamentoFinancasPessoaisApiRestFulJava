package FinancaPessoal.Api.repository.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import FinancaPessoal.Api.model.Transaction;
import FinancaPessoal.Api.repository.TransactionRepository;
import FinancaPessoal.Api.service.TransactionService;

@Repository
public class TransactionImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Optional<Transaction> findById(Integer id) {
		return transactionRepository.findById(id);
	}

	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}
	
	@Override
	public void removeById(Integer id) {
		transactionRepository.deleteById(id);		
	}

	@Override
	public List<Transaction> findAll() {		
		return transactionRepository.findAll();
	}

	
}
