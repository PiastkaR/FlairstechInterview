package com.interview.service;

import com.interview.domain.CountryLanguage;
import com.interview.repository.CountryLanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryLanguageService {

    private CountryLanguageRepository countryLanguageRepository;

    public List<CountryLanguage> getAllCities() {
        ArrayList<CountryLanguage> languages = new ArrayList<>();
        log.info("Retrieving all cities.");
        countryLanguageRepository.findAll().forEach(languages::add);

        return languages;
    }

    public CountryLanguage getCountryLanguageById(Character id) {
        log.info(String.format("Getting CountryLanguage by it's id: '%s'", id));

        return countryLanguageRepository.findById(id.toString()).get();
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
