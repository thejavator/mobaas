package com.omt.mobaas.config;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Page;
import com.omt.mobaas.model.PageLayout;
import com.omt.mobaas.model.Section;
import com.omt.mobaas.repository.ApplicationRepository;
import com.omt.mobaas.repository.PageLayoutRepository;
import com.omt.mobaas.repository.PageRepository;
import com.omt.mobaas.repository.SectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Configuration
@EnableJpaAuditing
public class DefinitionConfig {

    @Bean
    CommandLineRunner commandLineRunner(ApplicationRepository applicationRepository,
                                        PageRepository pageRepository,
                                        SectionRepository sectionRepository,
                                        PageLayoutRepository pageLayoutRepository) {
        return args -> {
            final Application myapp1 = new Application("myapp");
            final Application myapp2 = new Application("myapp");
            applicationRepository.saveAll(List.of(myapp1, myapp2));
            final Page page1 = new Page("ScreenName1",
                    true,
                    "Title1",
                    "Desc1");
            page1.setApplication(myapp1);
            final Page page2 = new Page("ScreenName2",
                    true,
                    "Title2",
                    "Desc2");
            page2.setApplication(myapp1);
            final Page page3 = new Page("ScreenName3",
                    true,
                    "Title3",
                    "Desc3");
            page3.setApplication(myapp2);
            final Section section1 = new Section("sectionName1", "sectionTitle1");
            final Section section2 = new Section("sectionName2", "sectionTitle2");

            pageRepository.saveAll(List.of(page1, page2, page3));
            sectionRepository.saveAll(List.of(section1, section2));


            PageLayout pl1 = new PageLayout(page1, section1, 1);
            PageLayout pl2 = new PageLayout(page1, section2, 2);
            pageLayoutRepository.saveAll(List.of(pl1, pl2));

        };
    }
}
