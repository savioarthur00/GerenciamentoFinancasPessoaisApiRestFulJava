package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.handler.BusinessException;
import FinancaPessoal.Api.model.User;
import FinancaPessoal.Api.repository.UserRepository;
import FinancaPessoal.Api.service.UserService;

@Repository
public class UserRespositoryImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
		
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Integer id) {
		
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
		String pass = user.getPassword();
    	user.setPassword(encoder.encode(pass));
		userRepository.save(user);
		
	}

	
	
	@Override
	public void removeById(Integer id) {
		userRepository.deleteById(id);
		
	}

	

	

	

}
