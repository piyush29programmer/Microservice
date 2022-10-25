package com.in28minutes.rest.webservices.restfulwebwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate >Database
    //UserDaoService >static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Jim_1", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve", LocalDate.now().minusYears(20)));
        users.add(new User(3,"Jim", LocalDate.now().minusYears(50)));
        users.add(new User(1,"Jim", LocalDate.now().minusYears(70)));
    }


    public List<User> findAll(){
        return users;
    }


    //public User save(User user)
    public User findOne(int id){

        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }



}
