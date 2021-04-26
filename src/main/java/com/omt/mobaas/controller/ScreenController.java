package com.omt.mobaas.controller;

import com.omt.mobaas.model.Application;
import com.omt.mobaas.model.Screen;
import com.omt.mobaas.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ScreenController {

    private final AppService definitionService;

    @Autowired
    public ScreenController(AppService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping(value = "/v1/screens", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Screen> getScreen() {
        return definitionService.getScreens();
    }


}
