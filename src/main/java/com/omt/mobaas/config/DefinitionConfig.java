package com.omt.mobaas.config;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Screen;
import com.omt.mobaas.repository.ApplicationRepository;
import com.omt.mobaas.repository.ScreenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.List;

@Configuration
@EnableJpaAuditing
public class DefinitionConfig {

    @Bean
    CommandLineRunner commandLineRunner(ApplicationRepository applicationRepository, ScreenRepository screenRepository) {
        return args -> {
            final Application myapp1 = new Application("myapp");
            final Application myapp2 = new Application("myapp");
            applicationRepository.saveAll(List.of(myapp1, myapp2));
            final Screen screen1 = new Screen("ScreenName1",
                    true,
                    "Title1",
                    "Desc1");
            screen1.setApplication(myapp1);
            final Screen screen2 = new Screen("ScreenName2",
                    true,
                    "Title2",
                    "Desc2");
            screen2.setApplication(myapp1);
            final Screen screen3 = new Screen("ScreenName3",
                    true,
                    "Title3",
                    "Desc3");
            screen3.setApplication(myapp2);
            screenRepository.saveAll(List.of(screen1, screen2, screen3));
        };
    }
}
