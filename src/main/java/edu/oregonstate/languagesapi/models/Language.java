package edu.oregonstate.languagesapi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="languages")
public class Language extends BaseEntity {

    private String name;

    private Integer speakers;

    @ManyToMany
    @JoinTable(name = "languages_countries", joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
