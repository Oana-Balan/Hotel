package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String findUtilizator(String email, String parola) {
		String util = userRepository.findByEmailAndParola(email,parola);
		return util;
	}
	
	public Integer findId(String email, String parola,String utilizator) {
		Integer id = userRepository.findByEmailAndParolaAndUtilizator(email, parola, utilizator);
		return id;
	}
	
}
