package edu.oregonstate.languagesapi.models;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    private Integer speakers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }
}
