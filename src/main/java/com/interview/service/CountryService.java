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

    private CountryRepository countryRepository;

    public List<Country> getAllCities() {
        ArrayList<Country> countries = new ArrayList<>();
        log.info("Retrieving all cities.");
        countryRepository.findAll().forEach(countries::add);

        return countries;
    }

    public Country getCountryById(Character car) throws InvalidCountryCode {
        log.info(String.format("Getting country by it's id: '%s'", car));

        Optional<Country> optionalCountry = countryRepository.findById(car);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        } else {
            throw new InvalidCountryCode(car.toString());
        }
    }

    public void saveOrUpdate(Country country) {
        log.info(String.format("Saving country: '%s'", country.getName()));
        countryRepository.save(country);
    }

    public void delete(Character id) {
        log.info(String.format("Deleting city by it's id: '%s'", id));
        countryRepository.deleteById(id);
    }
}
