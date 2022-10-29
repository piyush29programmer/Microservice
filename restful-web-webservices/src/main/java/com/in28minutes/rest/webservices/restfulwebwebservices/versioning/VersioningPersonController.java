package com.in28minutes.rest.webservices.restfulwebwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Piyush Kumar");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Piyush", "Kumar"));
    }

    @GetMapping(path="/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParamter(){
        return new PersonV1("Piyush Kumar");
    }

    @GetMapping(path="/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParamter(){
        return new PersonV2(new Name("Piyush", "Kumar"));
    }

    //Custom head versioning

    @GetMapping(path="/person/header",headers = "X-API-Version=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Piyush Kumar");
    }

    @GetMapping(path="/person/header",headers = "X-API-Version=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Piyush", "Kumar"));
    }
}
