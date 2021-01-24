package com.interview.repository;

import com.interview.domain.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
    Optional<CountryLanguage> findFirstByCountryLanguagePKCountryCodeAndIsOfficialIsTrue(String countryCode);
}
