package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country save(Country country);

    Country findById(Long id);

    void delete(Long id);
}
