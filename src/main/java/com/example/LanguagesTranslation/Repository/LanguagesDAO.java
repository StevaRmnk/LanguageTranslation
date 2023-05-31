package com.example.LanguagesTranslation.Repository;

import com.example.LanguagesTranslation.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesDAO extends JpaRepository<Language,Integer> {
}
