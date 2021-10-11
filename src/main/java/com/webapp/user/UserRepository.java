package com.webapp.user;


/*
 O spring disponibiliza uma classe repositorio que tem todas operações de crud por isso que criamos uma classe chamad UserRepositorio para extender
 esse crud do Spring.
 */
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
	public Long countById(Integer id);

}
