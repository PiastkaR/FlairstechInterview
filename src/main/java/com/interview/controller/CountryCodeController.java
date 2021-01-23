package com.interview.controller;

import com.interview.domain.CountryDto;
import com.interview.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping
public class CountryCodeController {

    private BusinessService businessService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryDto> getCountryInfo(@PathVariable("code") String code) {
        CountryDto countryInfo = businessService.getCountryInfo(code);

        return ResponseEntity.ok(countryInfo);
    }

    @ExceptionHandler
    public ResponseEntity<CountryDto> handleOtherException(final Exception exception) {
        log.error("Unexpected server error was encountered. ", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
