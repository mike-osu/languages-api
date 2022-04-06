package edu.oregonstate.languagesapi.controllers;

import edu.oregonstate.languagesapi.models.Language;
import edu.oregonstate.languagesapi.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping("/languages")
    public ResponseEntity<List<Language>> get() {
        List<Language> languages = languageService.findAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @PostMapping("/languages")
    public ResponseEntity<Language> save(@RequestBody Language language) {
        Language exp = languageService.save(language);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<Language> get(@PathVariable("id") Long id) {
        Language language = languageService.findById(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        languageService.delete(id);
        return new ResponseEntity<String>("Language is deleted", HttpStatus.OK);
    }    
}
