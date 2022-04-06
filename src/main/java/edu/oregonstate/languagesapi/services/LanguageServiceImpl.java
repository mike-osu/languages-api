package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.Language;
import edu.oregonstate.languagesapi.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language save(Language language) {
        languageRepository.save(language);
        return language;
    }

    @Override
    public Language findById(Long id) {
        if (languageRepository.findById(id).isPresent()) {
            return languageRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Language language = findById(id);
        languageRepository.delete(language);
    }    
}
