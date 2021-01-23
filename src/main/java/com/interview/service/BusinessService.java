package com.interview.service;

import com.interview.domain.Country;
import com.interview.domain.CountryDto;
import com.interview.domain.CountryLanguage;
import com.interview.exception.InvalidCountryCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessService {

    private CountryService countryService;
    private CountryLanguageService countryLanguageService;

    public CountryDto getCountryInfo(Character code) {
        CountryDto countryDto = null;
        try {
            countryDto = fromCountry(code);
        } catch (InvalidCountryCode invalidCountryCode) {
            invalidCountryCode.printStackTrace();
        }

        return countryDto;
    }

    private CountryDto fromCountry(Character code) throws InvalidCountryCode {
        Country country = countryService.getCountryById(code);
        String countryContinent = country.getContinent();
        CountryDto.Continent continent = CountryDto.Continent.valueOf(countryContinent);

        CountryLanguage countryLanguage = countryLanguageService.getCountryLanguageById(code);
        String language = countryLanguage.getCountryLanguagePK().getLanguage();

        return CountryDto.builder()
                .name(country.getName())
                .continent(continent)
                .population(country.getPopulation())
                .lifeExpectancy(country.getLifeExpectancy())
                .countryLanguage(language)
                .build();
    }
}
