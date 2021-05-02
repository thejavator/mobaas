package com.omt.mobaas.service;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Page;
import com.omt.mobaas.model.PageLayout;
import com.omt.mobaas.model.Section;
import com.omt.mobaas.repository.ApplicationRepository;
import com.omt.mobaas.repository.PageLayoutRepository;
import com.omt.mobaas.repository.PageRepository;
import com.omt.mobaas.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private final ApplicationRepository applicationRepository;
    private final PageRepository pageRepository;
    private final SectionRepository sectionRepository;
    private final PageLayoutRepository pageLayoutRepository;

    @Autowired
    public AppService(ApplicationRepository applicationRepository,
                      PageRepository pageRepository,
                      SectionRepository sectionRepository,
                      PageLayoutRepository pageLayoutRepository) {
        this.applicationRepository = applicationRepository;
        this.pageRepository = pageRepository;
        this.sectionRepository = sectionRepository;
        this.pageLayoutRepository = pageLayoutRepository;
    }

    /**
     * Get application from given id.
     *
     * @param applicationId
     * @return
     * @throws IllegalArgumentException
     */
    public Application getApp(Long applicationId) throws IllegalArgumentException {
        final Optional<Application> application = applicationRepository.findById(applicationId);
        if (!application.isPresent()) {
            throw new IllegalArgumentException("Unknown input param.");
        }
        return application.get();
    }

    public List<Application> getApps() {
        return applicationRepository.findAll();
    }

    /**
     * Create new application.
     *
     * @param application
     */
    public Application createApp(Application application) {
        applicationRepository.save(application);
        return application;
    }

    /**
     * @param applicationId
     * @param page
     * @throws IllegalArgumentException
     */
    public Page addPage(Long applicationId, Page page) throws IllegalArgumentException {
        final Optional<Application> application = applicationRepository.findById(applicationId);
        if (!application.isPresent()) {
            throw new IllegalArgumentException("Unknown input param.");
        }
        page.setApplication(application.get());
        pageRepository.save(page);
        return page;
    }

    public List<Page> getPages() {
        return pageRepository.findAll();
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    /**
     * @param section
     * @return
     */
    public Section createSection(Section section) {
        sectionRepository.save(section);
        return section;
    }

    public Page addSectionToPage(Long pageId, Long sectionId, Integer position) {
        final Optional<Page> page = pageRepository.findById(pageId);
        final Optional<Section> section = sectionRepository.findById(sectionId);
        if (!page.isPresent() || !section.isPresent()) {
            throw new IllegalArgumentException("Unknown input param.");
        }
        PageLayout pageLayout = new PageLayout(page.get(), section.get(), position);
        pageLayoutRepository.save(pageLayout);
        return pageRepository.findById(pageId).get();
    }
}
