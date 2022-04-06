package edu.oregonstate.languagesapi.repositories;

import edu.oregonstate.languagesapi.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
