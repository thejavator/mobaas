package com.omt.mobaas.repository;

import com.omt.mobaas.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository
        extends JpaRepository<Section, Long> {

}
