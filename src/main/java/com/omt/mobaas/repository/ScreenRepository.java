package com.omt.mobaas.repository;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository
        extends JpaRepository<Screen, Long> {

}
