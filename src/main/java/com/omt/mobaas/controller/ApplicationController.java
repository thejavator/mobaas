package com.omt.mobaas.controller;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Page;
import com.omt.mobaas.service.AppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Application")
public class ApplicationController {

    private final AppService definitionService;

    @Autowired
    public ApplicationController(AppService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping(value = "/v1/applications/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Application getApp(@PathVariable(value = "id") Long id) {
        try {
            return definitionService.getApp(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Unknown input param", e);
        }
    }

    @GetMapping(value = "/v1/applications", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Application> getApps() {
        return definitionService.getApps();
    }

    @PostMapping("/v1/applications")
    public Application createApp(@RequestBody Application application) {
        return definitionService.createApp(application);
    }

    @PostMapping("/v1/applications/{id}/pages")
    public Page addPage(@PathVariable(value = "id") Long id, @RequestBody Page page) {
        try {
            return definitionService.addPage(id, page);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Unknown input param", e);
        }
    }

}
