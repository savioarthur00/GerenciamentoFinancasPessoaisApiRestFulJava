package FinancaPessoal.Api.repository;

import java.util.List;

import FinancaPessoal.Api.model.Account;

public interface AccountRepository {
	
	Account findbyId(Long id);
	
	void save (Account account);
	
	void delete (Account account);
	
	List<Account> findAll();
	

}
