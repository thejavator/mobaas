package com.omt.mobaas.controller;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Screen;
import com.omt.mobaas.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AppController {

    private final AppService definitionService;

    @Autowired
    public AppController(AppService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping(value = "/v1/applications/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Application getApp(@PathVariable(value = "id") Long id) {
        return definitionService.getApp(id);
    }

    @GetMapping(value = "/v1/applications", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Application> getApps() {
        return definitionService.getApps();
    }

    @PostMapping("/v1/applications")
    public void createApp(@RequestBody Application application) {
        definitionService.createApp(application);
    }

    @PostMapping("/v1/applications/{id}/screen")
    public Screen addScreen(@PathVariable(value = "id") Long id, @RequestBody Screen screen) {
       try {
           return definitionService.addScreen(id, screen);
       }catch (Exception exc){
           throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, "Application not found", exc);
       }
    }
}
