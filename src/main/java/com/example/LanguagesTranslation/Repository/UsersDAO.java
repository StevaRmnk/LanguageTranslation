package com.example.LanguagesTranslation.Repository;

import com.example.LanguagesTranslation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<User,String> {
}
