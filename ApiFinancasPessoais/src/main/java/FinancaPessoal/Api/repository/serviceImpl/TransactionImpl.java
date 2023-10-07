package FinancaPessoal.Api.repository.serviceImpl;

import java.util.List;

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
	public Transaction findById(Long id) {
		return transactionRepository.findById(id);
	}

	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

	@Override
	public void put(Long id, Transaction transaction) {
		Transaction transactionEncontrado =  transactionRepository.findById(id);
		
		if(transactionEncontrado != null) {
			transactionEncontrado.setAmount(transaction.getAmount());
			transactionEncontrado.setDescription(transaction.getDescription());
			transactionRepository.save(transactionEncontrado);
		}
		
	}

	@Override
	public void remove(Integer id) {
		transactionRepository.deleteById(id);		
	}

	@Override
	public List<Transaction> findAll() {		
		return transactionRepository.findAll();
	}

	
}
