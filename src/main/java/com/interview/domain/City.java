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
@Table(name= "city")
public class City {
    @Id
    private int id;

    private String name;

    @Column
    private char countryCode;

    private String district;

    private int population;
}
