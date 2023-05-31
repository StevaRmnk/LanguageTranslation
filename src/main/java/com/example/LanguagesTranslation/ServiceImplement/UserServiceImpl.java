package com.example.LanguagesTranslation.ServiceImplement;

import com.example.LanguagesTranslation.Model.User;
import com.example.LanguagesTranslation.Repository.UserRepository;
import com.example.LanguagesTranslation.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(String username) {
        return userRepository.findById(username).orElseGet(null);
    }
}
