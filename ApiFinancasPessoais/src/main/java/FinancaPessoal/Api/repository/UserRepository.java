package FinancaPessoal.Api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

		User save(User user);
		
		
		Optional<User> findById(@Param("id") Integer id);
		
		
		
	
}
