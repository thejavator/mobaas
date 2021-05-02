package com.omt.mobaas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Entity
@Table
public class PageLayout implements Serializable {


    @EmbeddedId
    private PageLayoutId id;

    @ManyToOne()
    @MapsId("pageId")
    @JoinColumn(name = "page_id")
    @JsonIgnore
    private Page page;

    @ManyToOne()
    @MapsId("sectionId")
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private Section section;

    @Column(name = "position")
    private Integer position;

    public PageLayout() {
    }

    public PageLayout(Page page, Section section, Integer position) {
        this.page = page;
        this.section = section;
        this.position = position;
        this.id = new PageLayoutId();
        this.id.setPageId(this.page.getId());
        this.id.setSectionId(this.section.getId());
    }

    public PageLayoutId getId() {
        return id;
    }

    public void setId(PageLayoutId id) {
        this.id = id;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageLayout that = (PageLayout) o;
        return Objects.equals(page, that.page) && Objects.equals(section, that.section) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, section, position);
    }
}
