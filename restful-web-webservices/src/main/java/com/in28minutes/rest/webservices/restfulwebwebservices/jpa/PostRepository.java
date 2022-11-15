package com.in28minutes.rest.webservices.restfulwebwebservices.jpa;

import com.in28minutes.rest.webservices.restfulwebwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
