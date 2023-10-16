package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.handler.BusinessException;
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
	public Account create(Account entity) {
		if(entity.getAccountname()==null) {
			throw new BusinessException(mensagemObrigatoria("Nome da conta"));
		}
				
		return accountRepository.save(entity);
	}

	@Override
	public Account update(Integer id, Account entity) {
		findById(id);
		return create(entity);
		
	}

	@Override
	public void delete(Integer id) {
		accountRepository.deleteById(id);
		
	}

	
	

}
