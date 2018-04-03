package com.yeti.core.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.host.User;

@CrossOrigin
public interface UserRepository extends JpaRepository<User, Integer> {

	 Optional<User> findByUsername(String userLogin);

	 Optional<User> findByEmailAddress(String emailAddress);
	
}