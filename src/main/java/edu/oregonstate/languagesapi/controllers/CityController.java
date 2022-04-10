package edu.oregonstate.languagesapi.controllers;

import edu.oregonstate.languagesapi.models.City;
import edu.oregonstate.languagesapi.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> get() {
        List<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> save(@RequestBody City city) {
        City cty = cityService.save(city);
        return new ResponseEntity<>(cty, HttpStatus.OK);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> get(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        cityService.delete(id);
        return new ResponseEntity<String>("City is deleted", HttpStatus.OK);
    }
}
