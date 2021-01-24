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

    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;

    public CountryDto getCountryInfo(String code) throws InvalidCountryCode {
        return fromCountry(code);
    }

    private CountryDto fromCountry(String code) throws InvalidCountryCode {
        Country country = countryService.getCountryByCode(code);
        String countryContinent = country.getContinent();
        CountryDto.Continent continent = CountryDto.Continent.valueOf(countryContinent);

        CountryLanguage countryLanguage = countryLanguageService.getCountryLanguageByCountryCode(code);
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
