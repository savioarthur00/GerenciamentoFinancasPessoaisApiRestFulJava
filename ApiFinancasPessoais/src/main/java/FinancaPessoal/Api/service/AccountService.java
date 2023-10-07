package FinancaPessoal.Api.service;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.Account;

@Service
public interface AccountService {
			
	Account findById(Long id);
	
	void save(Account account);
	
	void put(Long id, Account account);
	
	void remove(Integer id);
	
	
		

}
