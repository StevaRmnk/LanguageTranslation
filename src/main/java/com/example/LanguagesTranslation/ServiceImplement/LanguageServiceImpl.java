package com.example.LanguagesTranslation.ServiceImplement;

import com.example.LanguagesTranslation.Model.Language;
import com.example.LanguagesTranslation.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements com.example.LanguagesTranslation.Service.LanguageService {

    @Autowired
    private LanguageRepository languageRepository;


    @Override
    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language findLanguageById(int id) {
        return languageRepository.findById(id).orElseGet(null);
    }

    @Override
    public Optional<Language> findLanguageByName(String name) {
        return Optional.ofNullable(languageRepository.findLanguageByName(name).orElseGet(null));
    }

    @Override
    public Language saveNewLanguage(Language language) {
        return languageRepository.save(language);
    }
}
