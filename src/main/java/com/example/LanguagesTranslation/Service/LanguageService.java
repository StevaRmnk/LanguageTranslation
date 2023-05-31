package com.example.LanguagesTranslation.Service;

import com.example.LanguagesTranslation.Model.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

    List<Language> findAllLanguages();
    Language findLanguageById(int id);

    Optional<Language> findLanguageByName(String name);

    Language saveNewLanguage(Language language);
}
