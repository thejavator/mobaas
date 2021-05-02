package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omt.mobaas.dto.SectionDTO;
import com.omt.mobaas.model.audit.DateAudit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table
public class Page extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "page_seq_generator")
    @SequenceGenerator(name = "page_seq_generator", sequenceName = "page_seq_generator", allocationSize = 1)
    private Long id;
    private String name;
    @JsonProperty
    private Boolean isIndex;
    private String title;
    private String description;

    public Page() {
    }

    public Page(String name, Boolean isIndex, String title, String description) {
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


    @OneToMany(mappedBy = "page",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Collection<PageLayout> pageLayouts = new ArrayList<>();

    public void setPageLayouts(Collection<PageLayout> pageLayouts) {
        this.pageLayouts = pageLayouts;
    }

    public Collection<SectionDTO> getSections() {
        return pageLayouts.stream()
                .map(PageLayout::getSection)
                .map(section -> convertToDto(section))
                .collect(Collectors.toList());
    }

    private SectionDTO convertToDto(Section section) {
        final Integer position = section.getPageLayouts().stream()
                .filter(pl -> pl.getPage().getId() == this.id)
                .findFirst()
                .get()
                .getPosition();
        final SectionDTO sectionDto = new SectionDTO(section.getId(), section.getName(), section.getTitle(), position);
        return sectionDto;
    }


    public Collection<PageLayout> getPageLayouts() {
        return this.pageLayouts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(id, page.id) && Objects.equals(name, page.name) && Objects.equals(isIndex, page.isIndex) && Objects.equals(title, page.title) && Objects.equals(description, page.description) && Objects.equals(application, page.application) && Objects.equals(pageLayouts, page.pageLayouts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isIndex, title, description, application, pageLayouts);
    }
}
