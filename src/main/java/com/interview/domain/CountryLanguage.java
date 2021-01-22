package com.interview.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name= "country_language")
public class CountryLanguage {
    @Column
    private char countryCode;
    @Id
    private String language;
    private boolean isOfficial;
    private double percentage;
}
