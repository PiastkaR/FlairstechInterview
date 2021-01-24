package com.interview.controller;

import com.interview.domain.CountryDto;
import com.interview.exception.InvalidCountryCode;
import com.interview.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping
public class CountryCodeController {

    private final BusinessService businessService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryDto> getCountryInfo(@PathVariable("code") String code) {
        try {
            CountryDto countryInfo = businessService.getCountryInfo(code);
            return ResponseEntity.ok(countryInfo);
        } catch (InvalidCountryCode exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "INVALID_COUNTRY_CODE"
            );
        }
    }

    @ExceptionHandler({InternalError.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INTERNAL_ERROR")
    public ResponseEntity<String> handleException(InternalError exception) {
        log.error("INTERNAL_ERROR. ", exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
