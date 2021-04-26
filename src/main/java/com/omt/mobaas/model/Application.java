package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.omt.mobaas.model.audit.DateAudit;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Application extends DateAudit {

    @Id
    @SequenceGenerator(name = "application_sequence",
            sequenceName = "application_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "application_sequence"
    )
    private Long id;

    @NotNull
    private String name;

    public Application(String name) {
        this.name = name;
    }

    public Application() {

    }
    @OneToMany(
            mappedBy = "application",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Screen> screens = new ArrayList<>();

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen){
        if (!this.screens.contains(screen)) {
            screens.add(screen);
        }
    }
    public void removeScreen(Screen screen){
        if (this.screens.contains(screen)) {
            screens.add(screen);
        }
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

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
