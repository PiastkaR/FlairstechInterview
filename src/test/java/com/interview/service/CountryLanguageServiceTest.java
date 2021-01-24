package com.interview.service;

import com.interview.exception.InvalidCountryCode;
import com.interview.repository.CountryLanguageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryLanguageServiceTest {
    private final static String FAULT_CODE = "ABC";

    @Mock
    private CountryLanguageRepository countryLanguageRepository;

    @InjectMocks
    private CountryLanguageService countryLanguageService;

    @Test
    void getCountryLanguageByCountryCode() throws InvalidCountryCode {
        //Arrange & Act & Assert
        Assertions.assertThrows(InvalidCountryCode.class, () -> {
            countryLanguageService.getCountryLanguageByCountryCode(FAULT_CODE);
        });
    }
}