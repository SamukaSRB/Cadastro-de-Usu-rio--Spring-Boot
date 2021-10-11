package com.webapp.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Criamos um service para usar os metodos do UserRepository e aqui que vai ficar as operações com a base de dados 
Usamos o anotation @Service que contera a sobreposição do meto @Atuowired.
 */

@Service
public class UserService {
	@Autowired 
	private UserRepository repo;
	
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return  (List<User>)repo.findAll();
	}

	public void save(User user) {
		repo.save(user);		
	}
	
	public User get(Integer id) throws UserNotFoundException {
		Optional<User> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Could not find any users with ID" + id);
		
	}
	public void delete (Integer id) throws UserNotFoundException {
		Long count = repo.countById(id);
		if(count == null || count ==0) {
			throw new UserNotFoundException("Could not find any users with ID" + id );
		}
		repo.deleteById(id);
	}

}
