package FinancaPessoal.Api.repository.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.model.Transaction;
import FinancaPessoal.Api.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Override
	public Transaction findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
