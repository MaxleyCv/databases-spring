package iot.lviv.films.dto;

import java.util.Set;

public class DirectorDTO {
    private Integer id;
    private String name;
    private String surname;
    private Set<String> directedFilms;

    public DirectorDTO(Integer id, String name, String surname, Set<String> directedFilms) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.directedFilms = directedFilms;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<String> getDirectedFilms() {
        return directedFilms;
    }

    public void setDirectedFilms(Set<String> directedFilms) {
        this.directedFilms = directedFilms;
    }
}
