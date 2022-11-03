package com.in28minutes.rest.webservices.restfulwebwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList( new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"));
    }

    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue filteringListDynamic(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        //allow us to add filter logic

        /*
        * 1- Create MappingJacksonValue and add bean
        * 2- Create PropertyFilter and filter out fields that are required
        * 3- Create filterProvider and link filter and JsonProperty name declared on Bean
        * 4- Set filterProvider in MappingJacksonValue
        * 5- Return MappingJacksonValue
        */
        

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
