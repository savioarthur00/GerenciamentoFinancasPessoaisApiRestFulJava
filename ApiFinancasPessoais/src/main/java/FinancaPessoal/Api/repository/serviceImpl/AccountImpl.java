package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.handler.BusinessException;
import FinancaPessoal.Api.model.Account;
import FinancaPessoal.Api.repository.AccountRepository;
import FinancaPessoal.Api.service.AccountService;

@Repository
public class AccountImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Optional<Account> findById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public void save(Account account) {
		if(account.getAccountname()==null) {
			throw new BusinessException(mensagemObrigatoria("Nome da conta"));
		}
		accountRepository.save(account);
		
	}
	
	@Override
	public void removeById(Integer id) {
		accountRepository.deleteById(id);
		
	}
	

	

}
