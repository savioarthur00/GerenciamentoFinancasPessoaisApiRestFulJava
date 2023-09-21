package FinancaPessoal.Api.repository;

import java.util.List;

import FinancaPessoal.Api.model.User;

public interface UserRepository {

	User findById(Long id);
	
	void save(User user);
	
	void delete(User user);
	
	List<User>findAll();
	
	
}
