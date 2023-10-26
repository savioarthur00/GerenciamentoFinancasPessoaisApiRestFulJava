package FinancaPessoal.Api.repository.serviceImpl;

import static FinancaPessoal.Api.handler.MessageHandler.mensagemObrigatoria;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import FinancaPessoal.Api.handler.BusinessException;
import FinancaPessoal.Api.model.User;
import FinancaPessoal.Api.repository.UserRepository;
import FinancaPessoal.Api.service.UserService;

@Repository
public class UserRespositoryImpl implements UserService,UserDetailsService  {

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

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        userEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        UserDetails user = new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
        return user;
	}

	

	

	

}
