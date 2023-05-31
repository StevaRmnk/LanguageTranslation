package com.example.LanguagesTranslation.Controller;


import com.example.LanguagesTranslation.Model.Language;
import com.example.LanguagesTranslation.Model.Role;
import com.example.LanguagesTranslation.Model.User;
import com.example.LanguagesTranslation.Service.LanguageService;
import com.example.LanguagesTranslation.ServiceImplement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SecureHelloWorldController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LanguageService languageService;

    @GetMapping("/login")
    public ModelAndView checkLogin(@RequestParam String username, @RequestParam String password, HttpSession session){


        User oneUser = userService.findUser(username);

        if(oneUser == null) {
            ModelAndView page = new ModelAndView("helloworld");
            return page;   //Napisati stranicu sa svim jezicima
        }
        if(password.equals(oneUser.getPassword())) {
            if(oneUser.getRole().equals(Role.ADMINISTRATOR)) {
                session.setAttribute("user", oneUser);
                ModelAndView page = new ModelAndView("admin");
                return page;  //Napisati stranicu na kojoj se upisuju jezici
            }
            else {
                ModelAndView page =new ModelAndView("securehelloworld");
                return page; //Napisati stranicu koja vraca sigurnu stranicu svih jezika
            }
        }
        return new ModelAndView("error");
    }

    @PostMapping(value = "/addLanguage")
    public String addingLanguage(@RequestParam String language,@RequestParam String value,HttpSession sesion){

        Language newLanguage = new Language();
        newLanguage.setLanguage(language);
        newLanguage.setValue(value);
        languageService.saveNewLanguage(newLanguage);
        sesion.removeAttribute("user");

        return "redirect:/";
    }

    @GetMapping(value = "/loginpage")
    public ModelAndView loginPage(){
        ModelAndView page = new ModelAndView("login");
        return page;
    }
}
