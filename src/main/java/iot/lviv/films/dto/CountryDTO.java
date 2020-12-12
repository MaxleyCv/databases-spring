package iot.lviv.films.dto;

public class CountryDTO {
    private Integer id;
    private String name;
    private String president;

    public CountryDTO(Integer id, String name, String president) {
        this.id = id;
        this.name = name;
        this.president = president;
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

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }
}
