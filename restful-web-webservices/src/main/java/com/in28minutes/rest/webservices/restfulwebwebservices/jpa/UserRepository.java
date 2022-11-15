package com.in28minutes.rest.webservices.restfulwebwebservices.jpa;

import com.in28minutes.rest.webservices.restfulwebwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
