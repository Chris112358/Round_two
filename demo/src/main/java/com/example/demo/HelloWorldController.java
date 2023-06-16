package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String template = "Hello %s";
    @GetMapping("/api/showHello")
    public Hello showHello(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Hello(String.format(template, name));
    }

}
