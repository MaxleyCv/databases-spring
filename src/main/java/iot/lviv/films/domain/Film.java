package iot.lviv.films.domain;

import org.reflections.vfs.Vfs;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "publish_year")
  private Integer publishYear;

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  private Country countryOfOrigin;

  @ManyToOne
  @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
  private Director director;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "films")
  private Set<Actor> actors;

  @OneToMany(mappedBy = "film", fetch = FetchType.EAGER)
  private Set<Review> reviews;

  public Film(Integer id, String title, String description, Integer publishYear,
              Country countryOfOrigin, Director director, Set<Actor> actors,
              Set<Review> reviews) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.publishYear = publishYear;
    this.countryOfOrigin = countryOfOrigin;
    this.director = director;
    this.actors = actors;
    this.reviews = reviews;
  }

  public Film() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Film film = (Film) o;
    return id.equals(film.id) &&
        Objects.equals(title, film.title) &&
        Objects.equals(description, film.description) &&
        Objects.equals(publishYear, film.publishYear) &&
        Objects.equals(countryOfOrigin, film.countryOfOrigin) &&
        director.equals(film.director) &&
        Objects.equals(actors, film.actors) &&
        Objects.equals(reviews, film.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, publishYear, countryOfOrigin, director);
  }

  @Override
  public String toString() {
    return "Film{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", publishYear=" + publishYear +
        ", countryOfOrigin=" + countryOfOrigin +
        ", director=" + director +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPublishYear() {
    return publishYear;
  }

  public void setPublishYear(Integer publishYear) {
    this.publishYear = publishYear;
  }

  public Country getCountryOfOrigin() {
    return countryOfOrigin;
  }

  public void setCountryOfOrigin(Country countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public Set<Actor> getActors() {
    return actors;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Set<Review> reviews) {
    this.reviews = reviews;
  }

}
