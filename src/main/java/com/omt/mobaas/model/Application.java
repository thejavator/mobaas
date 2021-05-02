package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.omt.mobaas.model.audit.DateAudit;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Application extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private List<Page> pages = new ArrayList<>();

    public List<Page> getPages() {
        return pages;
    }

    public void addPage(Page page){
        if (!this.pages.contains(page)) {
            pages.add(page);
        }
    }
    public void removePage(Page page){
        if (this.pages.contains(page)) {
            pages.add(page);
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
