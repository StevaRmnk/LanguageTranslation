package com.example.LanguagesTranslation.Controller;

import com.example.LanguagesTranslation.Model.Language;
import com.example.LanguagesTranslation.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@Profile("db")
public class TranslationController {

    @Autowired
    private LanguageService languageService;

    @GetMapping(value = "/hello/{language}")
    public ModelAndView getTranslationFromDatabase(@PathVariable("language") String language){

        ModelAndView page = new ModelAndView("helloworld");

        Optional<Language> lang = languageService.findLanguageByName(language);
        if(lang.isPresent()) {
            page.addObject("text", lang.get().getValue());
        } else {
            page.addObject("text", "You haven't defined language!");
        }

        return page;
    }
}
