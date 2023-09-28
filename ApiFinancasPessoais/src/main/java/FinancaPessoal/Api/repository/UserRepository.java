package FinancaPessoal.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findById(Long id);
	
	User save(User user);
	
	void delete(User user);
	
	List<User>findAll();
	
	
}
