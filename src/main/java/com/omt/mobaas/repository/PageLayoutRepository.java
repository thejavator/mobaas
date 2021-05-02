package com.omt.mobaas.repository;

import com.omt.mobaas.model.PageLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageLayoutRepository
        extends JpaRepository<PageLayout, Long> {

}
