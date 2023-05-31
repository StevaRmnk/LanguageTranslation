package com.example.LanguagesTranslation.Controller;

import com.example.LanguagesTranslation.ServiceImplement.ExternalApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@Profile("externalAPI")
public class ExternalAPIController {

    @Autowired
    private ExternalApiServiceImpl externalApiService;

    @GetMapping("/hello/{language}")
    public ModelAndView getTranslationsFromAPI(Model modelMessage, @PathVariable(value = "language") String language) throws IOException, InterruptedException {
        return externalApiService.getTranslationsFromAPI(language);
    }
}
