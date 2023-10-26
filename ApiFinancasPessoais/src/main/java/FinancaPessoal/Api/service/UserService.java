package FinancaPessoal.Api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.User;



@Service
public interface UserService {
	
	Iterable<User> findAll();
	
	Optional<User> findById(Integer id);
	
	void save(User user);
	
	void removeById(Integer id);

	void deleteById(Integer id);
	

}
