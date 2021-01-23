package com.interview.service;

import com.interview.domain.City;
import com.interview.exception.InvalidCountryCode;
import com.interview.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        ArrayList<City> cities = new ArrayList<>();
        log.info("Retrieving all cities.");
        cityRepository.findAll().forEach(cities::add);

        return cities;
    }

    public City getCityById(Integer id) throws InvalidCountryCode {
        log.info(String.format("Getting city by it's id: '%s'", id));

        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            return optionalCity.get();
        } else {
            throw new InvalidCountryCode(id.toString());
        }
    }

    public void saveOrUpdate(City city) {
        log.info(String.format("Saving city: '%s'", city.getName()));
        cityRepository.save(city);
    }

    public void delete(Integer id) {
        log.info(String.format("Deleting city by it's id: '%s'", id));
        cityRepository.deleteById(id);
    }
}
