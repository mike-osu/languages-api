package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City save(City city);

    City findById(Long id);

    void delete(Long id);
}
