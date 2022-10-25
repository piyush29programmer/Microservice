package com.in28minutes.rest.webservices.restfulwebwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest API
@RestController
public class HelloWorldController {

    //hello-world

    //return "Hello World"

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
