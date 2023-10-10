package FinancaPessoal.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FinancaPessoal.Api.model.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>  {
	
	Account findById(Long id);
	
	Account save (Account account);
	
	void deleteById (Account account);
	
	
	

}
