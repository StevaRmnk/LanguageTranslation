package com.example.LanguagesTranslation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping(value = "/")
    public ModelAndView helloWorldDefault(){
        ModelAndView page = new ModelAndView("helloworld");
        return  page;
    }

    @GetMapping(value = "/hello")
    public ModelAndView helloWorldPage(){
        ModelAndView page = new ModelAndView("helloworld");
        return  page;
    }
}
