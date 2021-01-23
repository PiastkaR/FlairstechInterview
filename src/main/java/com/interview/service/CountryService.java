package com.interview.service;

import com.interview.domain.Country;
import com.interview.exception.InvalidCountryCode;
import com.interview.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCities() {
        ArrayList<Country> countries = new ArrayList<>();
        log.info("Retrieving all cities.");
        countryRepository.findAll().forEach(countries::add);

        return countries;
    }

    public Country getCountryByCode(String code) throws InvalidCountryCode {
        log.info(String.format("Getting country by it's id: '%s'", code));

        Optional<Country> optionalCountry = countryRepository.findByCode(code);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        } else {
            throw new InvalidCountryCode(code);
        }
    }

    public void saveOrUpdate(Country country) {
        log.info(String.format("Saving country: '%s'", country.getName()));
        countryRepository.save(country);
    }

    public void delete(String id) {
        log.info(String.format("Deleting city by it's id: '%s'", id));
        countryRepository.deleteById(id);
    }
}
