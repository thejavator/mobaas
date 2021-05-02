package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omt.mobaas.model.audit.DateAudit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table
public class Section extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_seq_generator")
    @SequenceGenerator(name = "section_seq_generator", sequenceName = "section_seq_generator", allocationSize = 1)
    private Long id;
    private String name;
    private String title;

    public Section() {
    }

    public Section(String name, String title) {
        this.name = name;
        this.title = title;
    }
    @OneToMany(mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private Collection<PageLayout> pageLayouts = new ArrayList<>();

    public Collection<PageLayout> getPageLayouts() {
        return pageLayouts;
    }

    public void setPageLayouts(Collection<PageLayout> pageLayouts) {
        this.pageLayouts = pageLayouts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id) && Objects.equals(name, section.name) && Objects.equals(title, section.title) && Objects.equals(pageLayouts, section.pageLayouts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, pageLayouts);
    }
}
