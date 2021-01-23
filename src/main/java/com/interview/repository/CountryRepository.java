package com.interview.repository;

import com.interview.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Character> {
    Optional<Country> findById(String car);
}
