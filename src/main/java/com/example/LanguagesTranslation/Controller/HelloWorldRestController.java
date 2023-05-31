package com.example.LanguagesTranslation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/hello-rest")
    public String HelloWorld(){
        return "Hello World!";
    }
}
