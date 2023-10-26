package FinancaPessoal.Api.repository.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.model.Account;
import FinancaPessoal.Api.repository.AccountRepository;
import FinancaPessoal.Api.service.CrudService;

@Repository
public class AccountImpl implements CrudService<Integer,Account> {

	@Autowired
	private AccountRepository accountRepository;
	
	

	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> findById(Integer id) {
		return accountRepository.findById(id);
	}

	

	@Override
	public Account update( Account entity) {
		findById(entity.getId());
		return create(entity);
		
	}

	@Override
	public void delete(Integer id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public Account create(Account entity) {
	
		accountRepository.save(entity);
		return entity;
	
		
		
		
	}

	
	

}
