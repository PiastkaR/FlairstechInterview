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
//@IdClass(CountryLanguagePK.class)
public class CountryLanguage implements Serializable {
    @EmbeddedId
    private CountryLanguagePK countryLanguagePK;

//    @Id
//    @Column(name = "country_code", nullable = false)
//    @JoinColumn(name = "code")
//    private char countryCode;
//
//    @Id
//    @Column(name = "language", nullable = false)
//    private String language;

    @Column(name = "is_official", nullable = false)
    private boolean isOfficial;

    @Column(name = "percentage", nullable = false)
    private double percentage;

    @Embeddable
    @Data
    public class CountryLanguagePK implements Serializable {
        protected char countryCode;
        protected String language;

        public CountryLanguagePK(char countryCode, String language) {
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
