package edu.oregonstate.languagesapi.services;

import edu.oregonstate.languagesapi.models.City;
import edu.oregonstate.languagesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City save(City city) {
        cityRepository.save(city);
        return city;
    }

    @Override
    public City findById(Long id) {
        if (cityRepository.findById(id).isPresent()) {
            return cityRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        City city = findById(id);
        cityRepository.delete(city);
    }
}
