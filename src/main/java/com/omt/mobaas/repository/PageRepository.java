package com.omt.mobaas.repository;

import com.omt.mobaas.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository
        extends JpaRepository<Page, Long> {

}
