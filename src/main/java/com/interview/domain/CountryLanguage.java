package com.interview.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "country_language")
public class CountryLanguage implements Serializable {
    @EmbeddedId
    private CountryLanguagePK countryLanguagePK;

    @Column(name = "is_official", nullable = false)
    private boolean isOfficial;

    @Column(name = "percentage", nullable = false)
    private double percentage;

    @Embeddable
    @Data
    public static class CountryLanguagePK implements Serializable {
        @Column(name = "country_code", nullable = false)
        protected String countryCode;
        @Column(name = "language", nullable = false)
        protected String language;

        public CountryLanguagePK() {

        }

        public CountryLanguagePK(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CountryLanguagePK)) return false;
            CountryLanguagePK that = (CountryLanguagePK) o;
            return countryCode == that.countryCode &&
                    Objects.equals(language, that.language);
        }

        @Override
        public int hashCode() {
            return Objects.hash(countryCode, language);
        }
    }

}
