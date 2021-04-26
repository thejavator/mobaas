package com.omt.mobaas.service;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Screen;
import com.omt.mobaas.repository.ApplicationRepository;
import com.omt.mobaas.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private final ApplicationRepository applicationRepository;
    private final ScreenRepository screenRepository;

    @Autowired
    public AppService(ApplicationRepository applicationRepository, ScreenRepository screenRepository) {
        this.applicationRepository = applicationRepository;
        this.screenRepository = screenRepository;
    }

    public Application getApp(Long appId) {
        return applicationRepository.findById(appId).get();
    }
    public List<Application> getApps() {
        return applicationRepository.findAll();
    }

    /**
     * Create new application
     *
     * @param application
     */
    public void createApp(Application application) {
        applicationRepository.save(application);
    }

    /**
     * @param applicationId
     * @param screen
     * @throws IllegalArgumentException
     */
    public Screen addScreen(Long applicationId, Screen screen) throws IllegalArgumentException {

        Optional<Application> application = applicationRepository.findById(applicationId);
        if (!application.isPresent()) {
            throw new IllegalArgumentException("Application does not existe.");
        }
        screen.setApplication(application.get());
        screenRepository.save(screen);
        return screen;
    }

    public List<Screen> getScreens() {
        return screenRepository.findAll();
    }


}
