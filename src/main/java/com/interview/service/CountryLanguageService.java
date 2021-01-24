package com.interview.service;

import com.interview.domain.CountryLanguage;
import com.interview.exception.InvalidCountryCode;
import com.interview.repository.CountryLanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public List<CountryLanguage> getAllCities() {
        ArrayList<CountryLanguage> languages = new ArrayList<>();
        log.info("Retrieving all cities.");
        countryLanguageRepository.findAll().forEach(languages::add);

        return languages;
    }

    public CountryLanguage getCountryLanguageByCountryCode(String countryCode) throws InvalidCountryCode {
        log.info(String.format("Getting CountryLanguage by it's code: '%s'", countryCode));

        Optional<CountryLanguage> optionalCountryLanguage = countryLanguageRepository.findFirstByCountryLanguagePKCountryCodeAndIsOfficialIsTrue(countryCode);
        if (optionalCountryLanguage.isPresent()) {
            CountryLanguage countryLanguage = optionalCountryLanguage.get();
            return isCountryLanguageOfficial(countryLanguage);
        } else {
            throw new InvalidCountryCode(countryCode);
        }
    }

    private CountryLanguage isCountryLanguageOfficial(CountryLanguage countryLanguage) {
        log.info(String.format("Is CountryLanguage official? '%s'", countryLanguage.isOfficial()));
        return countryLanguage;
    }

    public void saveOrUpdate(CountryLanguage countryLanguage) {
        log.info(String.format("Saving CountryLanguage: '%s'", countryLanguage.getCountryLanguagePK().getLanguage()));
        countryLanguageRepository.save(countryLanguage);
    }

    public void delete(String id) {
        log.info(String.format("Deleting CountryLanguage by it's id: '%s'", id));
        countryLanguageRepository.deleteById(id);
    }
}
