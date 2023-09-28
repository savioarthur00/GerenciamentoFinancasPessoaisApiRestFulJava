package FinancaPessoal.Api.service;

import org.springframework.stereotype.Service;

import FinancaPessoal.Api.model.User;



@Service
public interface UserService {
	
	Iterable<User> findAll();
	
	User findById(Long id);
	
	void save(User user);
	
	void put(Long id,User user);
	
	void remove(Integer id);
	

}
