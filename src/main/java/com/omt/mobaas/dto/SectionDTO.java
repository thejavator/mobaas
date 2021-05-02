package com.omt.mobaas.dto;

public class SectionDTO  {


    private Long id;
    private String name;
    private String title;
    private Integer position;

    public SectionDTO() {
    }

    public SectionDTO(Long id, String name, String title, Integer position) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.position = position;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
