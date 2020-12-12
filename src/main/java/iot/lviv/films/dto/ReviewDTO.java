package iot.lviv.films.dto;

public class ReviewDTO {
    private Integer id;
    private Integer points;
    private String textOfReview;
    private Integer userId;

    public ReviewDTO(Integer id, Integer points, String textOfReview, Integer userId) {
        this.id = id;
        this.points = points;
        this.textOfReview = textOfReview;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
