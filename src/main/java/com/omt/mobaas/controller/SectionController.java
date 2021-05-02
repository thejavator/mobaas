package com.omt.mobaas.controller;

import com.omt.mobaas.model.Section;
import com.omt.mobaas.service.AppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Section")
public class SectionController {

    private final AppService appService;

    @Autowired
    public SectionController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(value = "/v1/sections", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Section> getSections() {
        return appService.getSections();
    }

    @PostMapping(value = "/v1/sections", produces = MediaType.APPLICATION_JSON_VALUE)
    public Section createApp(@RequestBody Section section) {
        return appService.createSection(section);
    }

}
