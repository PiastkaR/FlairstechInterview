package com.interview.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CountryDto {
    private String name;
    private Continent continent;
    private double population;
    private double lifeExpectancy;
    private String countryLanguage;

    public enum Continent {
        Asia, Europe, NorthAmerica, Africa, Oceania, Antarctica, SouthAmerica
    }
}
