package edu.oregonstate.languagesapi.controllers;

import edu.oregonstate.languagesapi.models.Country;
import edu.oregonstate.languagesapi.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> get() {
        List<Country> countries = countryService.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> save(@RequestBody Country country) {
        Country exp = countryService.save(country);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> get(@PathVariable("id") Long id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        countryService.delete(id);
        return new ResponseEntity<String>("Country is deleted", HttpStatus.OK);
    }
}
