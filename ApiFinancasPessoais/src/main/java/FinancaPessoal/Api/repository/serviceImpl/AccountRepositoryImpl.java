package FinancaPessoal.Api.repository.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.model.Account;
import FinancaPessoal.Api.repository.AccountRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

	@Override
	public Account findbyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
