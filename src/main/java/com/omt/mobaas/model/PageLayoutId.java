package com.omt.mobaas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PageLayoutId implements Serializable {


    @Column(name = "page_id")
    Long pageId;

    @Column(name = "section_id")
    Long sectionId;

    public PageLayoutId(Long sectionId, Long pageId) {
        this.pageId = pageId;
        this.sectionId = sectionId;
    }

    public PageLayoutId() {

    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageLayoutId that = (PageLayoutId) o;
        return Objects.equals(pageId, that.pageId) && Objects.equals(sectionId, that.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionId, pageId);
    }
}
