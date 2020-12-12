package iot.lviv.films.dto;

public class FilmDTO {
    private Integer id;
    private String title;
    private String description;
    private String directorName;
    private String publishYear;

    public FilmDTO(Integer id, String title, String description, String directorName, String publishYear) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.directorName = directorName;
        this.publishYear = publishYear;
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

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
