package com.example.LanguagesTranslation.Repository;

import com.example.LanguagesTranslation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
