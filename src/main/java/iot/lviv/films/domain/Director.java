package iot.lviv.films.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
  private Set<Film> directedFilms;

  public Director(Integer id, String name, String surname, Set<Film> directedFilms) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.directedFilms = directedFilms;
  }

  public Director() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Director director = (Director) o;
    return id.equals(director.id) &&
        Objects.equals(name, director.name) &&
        Objects.equals(surname, director.surname) &&
        Objects.equals(directedFilms, director.directedFilms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname);
  }

  @Override
  public String toString() {
    return "Director{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
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

  public Set<Film> getDirectedFilms() {
    return directedFilms;
  }

  public void setDirectedFilms(Set<Film> directedFilms) {
    this.directedFilms = directedFilms;
  }

}
