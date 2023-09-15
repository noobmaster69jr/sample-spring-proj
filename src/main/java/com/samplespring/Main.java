package com.samplespring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication // combination of configuration, ComponentScan, EnableAutoConfiguration

@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse("Hello",
                List.of("java", "javascript", "python"),
                new Person("Alex"));
        return response;
    }

    // @RestController - tells that class is controller and all mapping methods return a json

    record Person(String name){

    }

    record GreetResponse(String greet,
                         List<String> favProgrammingLang,
                         Person person){}



    //without record we have to create a GreetResponse class and override hashcode,
    // toString, implement final datamember greet, and public getter ...
}
