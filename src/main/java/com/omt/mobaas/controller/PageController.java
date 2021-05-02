package com.omt.mobaas.controller;

import com.omt.mobaas.dto.SectionDTO;
import com.omt.mobaas.model.Page;
import com.omt.mobaas.model.Section;
import com.omt.mobaas.service.AppService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PageController {

    private final AppService definitionService;

    @Autowired
    public PageController(AppService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping(value = "/v1/pages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Page> getPages() {
        return definitionService.getPages();
    }

    @PostMapping("/v1/pages/{id}/screens")
    public Page addPage(@PathVariable(value = "id") Long id, @RequestBody Page page) {
        try {
            return definitionService.addPage(id, page);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Application not found", e);
        }
    }

}
