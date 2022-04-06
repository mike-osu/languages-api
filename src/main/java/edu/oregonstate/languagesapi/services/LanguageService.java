package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.Language;

import java.util.List;

public interface LanguageService {

    List<Language> findAll();

    Language save(Language expense);

    Language findById(Long id);

    void delete(Long id);    
}
