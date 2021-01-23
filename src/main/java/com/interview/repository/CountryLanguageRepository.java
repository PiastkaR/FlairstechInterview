package com.interview.repository;

import com.interview.domain.CountryLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends CrudRepository<CountryLanguage, String> {
}
