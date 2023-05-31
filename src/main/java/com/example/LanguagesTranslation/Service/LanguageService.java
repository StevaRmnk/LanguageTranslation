package com.example.LanguagesTranslation.Service;

import com.example.LanguagesTranslation.Model.Language;

import java.util.List;

public interface LanguageService {

    List<Language> findAllLanguages();
    Language findLanguageById(int id);

    Language findLanguageByName(String name);

    Language saveNewLanguage(Language language);
}
