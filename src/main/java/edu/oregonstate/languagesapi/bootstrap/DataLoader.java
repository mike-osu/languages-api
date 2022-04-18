package edu.oregonstate.languagesapi.bootstrap;

import edu.oregonstate.languagesapi.models.City;
import edu.oregonstate.languagesapi.models.Country;
import edu.oregonstate.languagesapi.models.Language;
import edu.oregonstate.languagesapi.repositories.CityRepository;
import edu.oregonstate.languagesapi.repositories.CountryRepository;
import edu.oregonstate.languagesapi.repositories.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final LanguageRepository languageRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    
    private Country usa;
    private Country france;
    private Country canada;

    public DataLoader(LanguageRepository languageRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.languageRepository = languageRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Language> languages = languageRepository.findAll();
        if (languages.size() > 0)
            return;

        loadCountries();
        loadLanguages();
        loadCities();
    }

    private void loadCountries() {
        usa = new Country();
        usa.setName("United States");
        usa.setContinent("North America");
        countryRepository.save(usa);

        france = new Country();
        france.setName("France");
        france.setContinent("Europe");
        countryRepository.save(france);

        canada = new Country();
        canada.setName("Canada");
        canada.setContinent("North America");
        countryRepository.save(canada);

        System.out.println("Country data Loaded = " + countryRepository.count());
    }

    private void loadLanguages() {
        Language english = new Language();
        english.setName("English");
        english.setSpeakers(1452);
        english.getCountries().add(usa);
        english.getCountries().add(canada);
        languageRepository.save(english);

        Language french = new Language();
        french.setName("French");
        french.setSpeakers(274);
        french.getCountries().add(france);
        french.getCountries().add(canada);
        languageRepository.save(french);

        System.out.println("Language data Loaded = " + languageRepository.count());
    }

    private void loadCities() {
        City corvallis = new City();
        corvallis.setName("Corvallis");
        corvallis.setCapital(false);
        corvallis.setCountry(usa);
        cityRepository.save(corvallis);

        City la = new City();
        la.setName("Los Angeles");
        la.setCapital(false);
        la.setCountry(usa);
        cityRepository.save(la);

        City paris = new City();
        paris.setName("Paris");
        paris.setCapital(true);
        paris.setCountry(france);
        cityRepository.save(paris);

        City ottawa = new City();
        ottawa.setName("Ottawa");
        ottawa.setCapital(true);
        ottawa.setCountry(canada);
        cityRepository.save(ottawa);

        System.out.println("City data Loaded = " + cityRepository.count());
    }
}
