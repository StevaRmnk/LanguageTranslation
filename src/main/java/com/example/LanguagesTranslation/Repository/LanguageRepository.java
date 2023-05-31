package com.example.LanguagesTranslation.Repository;

import com.example.LanguagesTranslation.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language,Integer> {

    @Query(value="select * from languages l where lower(l.language) like lower(?1)",nativeQuery = true)
    Optional<Language> findLanguageByName(String language_name);

}
