package iot.lviv.films.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "appendix")
  private String appendix;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @ManyToMany
  @JoinTable(
      name = "film_has_actor",
      joinColumns = @JoinColumn(
          name = "film_id",
          referencedColumnName = "id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "actor_id",
          referencedColumnName = "id"
      )
  )
  private Set<Film> films;

  public Actor(Integer id, String appendix, String name, String surname, Set<Film> films) {
    this.id = id;
    this.appendix = appendix;
    this.name = name;
    this.surname = surname;
    this.films = films;
  }

  public Actor() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Actor actor = (Actor) o;
    return id.equals(actor.id) &&
        Objects.equals(appendix, actor.appendix) &&
        name.equals(actor.name) &&
        surname.equals(actor.surname) &&
        films.equals(actor.films);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, appendix, name, surname);
  }

  @Override
  public String toString() {
    return "Actor{" +
        "id=" + id +
        ", appendix='" + appendix + '\'' +
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

  public String getAppendix() {
    return appendix;
  }

  public void setAppendix(String appendix) {
    this.appendix = appendix;
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

  public Set<Film> getFilms() {
    return films;
  }

  public void setFilms(Set<Film> films) {
    this.films = films;
  }

}
