package FinancaPessoal.Api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.Account;

@Service
public interface AccountService {
			
	Optional<Account> findById(Integer id);
	
	void save(Account account);
		
	void removeById(Integer id);
	
	
		

}
