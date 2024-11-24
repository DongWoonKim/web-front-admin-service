package com.example.spring.webfrontadminservice.controller;

import com.example.spring.webfrontadminservice.dto.CreateCatalogRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/catalog")
public class CatalogApiController {

    @PostMapping
    public void createCatalog(@RequestBody CreateCatalogRequestDTO createCatalogRequestDTO) {

    }

}
