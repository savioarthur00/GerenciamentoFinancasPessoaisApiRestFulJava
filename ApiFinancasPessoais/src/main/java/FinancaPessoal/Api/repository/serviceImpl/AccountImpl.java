package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

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
	public Account findById(Long id) {
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
	public void put(Long id, Account account) {
		Account accountEncontrada = accountRepository.findById(id);
		
		if(accountEncontrada != null) {
			accountEncontrada.setAccountname(account.getAccountname());
			accountEncontrada.setBalance(account.getBalance());
			accountEncontrada.setTransactions(account.getTransactions());
			accountRepository.save(accountEncontrada);
		}
		
	}

	@Override
	public void remove(Integer id) {
		accountRepository.deleteById(id);
		
	}
	

	

}
