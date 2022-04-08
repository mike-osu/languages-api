package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.Country;
import edu.oregonstate.languagesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        countryRepository.save(country);
        return country;
    }

    @Override
    public Country findById(Long id) {
        if (countryRepository.findById(id).isPresent()) {
            return countryRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Country country = findById(id);
        countryRepository.delete(country);
    }
}
