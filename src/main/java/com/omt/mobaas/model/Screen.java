package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omt.mobaas.model.audit.DateAudit;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Screen extends DateAudit {

    @Id
    @SequenceGenerator(name = "application_sequence",
            sequenceName = "application_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "application_sequence"
    )
    private Long id;
    private String name;
    @JsonProperty
    private Boolean isIndex;
    private String title;
    private String description;

    public Screen() {
    }

    public Screen(String name, Boolean isIndex, String title, String description) {

        this.name = name;
        this.isIndex = isIndex;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Application application;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(Boolean isIndex) {
        this.isIndex = isIndex;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
