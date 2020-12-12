package iot.lviv.films.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "points")
  private Integer points;

  @Column(name = "text_of_review")
  private String textOfReview;

  @ManyToOne
  @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false)
  private Film film;

  @Column(name = "user_id")
  private Integer userId;

  public Review(Integer id, Integer points, String textOfReview, Film film, Integer userId) {
    this.id = id;
    this.points = points;
    this.textOfReview = textOfReview;
    this.film = film;
    this.userId = userId;
  }

  public Review() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return id.equals(review.id) &&
        Objects.equals(points, review.points) &&
        Objects.equals(textOfReview, review.textOfReview) &&
        film.equals(review.film) &&
        userId.equals(review.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, points, textOfReview, film, userId);
  }

  @Override
  public String toString() {
    return "Review{" +
        "id=" + id +
        ", points=" + points +
        ", textOfReview='" + textOfReview + '\'' +
        ", film=" + film +
        ", userId=" + userId +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public String getTextOfReview() {
    return textOfReview;
  }

  public void setTextOfReview(String textOfReview) {
    this.textOfReview = textOfReview;
  }

  public Film getFilm() {
    return film;
  }

  public void setFilm(Film film) {
    this.film = film;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
