package com.interview.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country_code", nullable = false)
    @JoinColumn(name = "code")
    private char countryCode;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "population", nullable = false)
    private int population;
}
