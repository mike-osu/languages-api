package edu.oregonstate.languagesapi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
//    private Set<City> cities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

//    public Set<City> getCities() {
//        return cities;
//    }
//
//    public void setCities(Set<City> cities) {
//        this.cities = cities;
//    }
}