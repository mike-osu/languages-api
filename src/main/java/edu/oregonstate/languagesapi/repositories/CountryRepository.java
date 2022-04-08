package edu.oregonstate.languagesapi.repositories;

import edu.oregonstate.languagesapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
