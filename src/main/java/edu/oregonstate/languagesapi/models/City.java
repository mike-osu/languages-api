package edu.oregonstate.languagesapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City extends BaseEntity {

    private String name;

    @Column(name = "is_capital")
    private Boolean isCapital;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return isCapital;
    }

    public void setCapital(Boolean capital) {
        isCapital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
