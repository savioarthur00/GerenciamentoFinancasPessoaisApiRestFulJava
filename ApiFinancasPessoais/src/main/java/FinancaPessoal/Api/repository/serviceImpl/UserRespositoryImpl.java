package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.handler.BusinessException;
import FinancaPessoal.Api.model.User;
import FinancaPessoal.Api.repository.UserRepository;
import FinancaPessoal.Api.service.UserService;

@Repository
public class UserRespositoryImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
		
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		
		if(user.getUsername()==null) {
			throw new BusinessException(mensagemObrigatoria("username"));
		}
		if(user.getPassword()==null) {
			throw new BusinessException(mensagemObrigatoria("senha"));
		}
		userRepository.save(user);
		
	}

	@Override
	public void put(Long id, User user) {
		User userBD = userRepository.findById(id);
		
		if(userBD != null) {
			userBD.setAccounts(user.getAccounts());
			userBD.setUsername(user.getUsername());
			userBD.setPassword(user.getPassword());
			userRepository.save(userBD);
		}
		
	}

	@Override
	public void remove(Integer id) {
		userRepository.deleteById(id);
	}

	

}
