package com.example.spring.webfrontadminservice.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateCatalogRequestDTO {
    private String isbn;
    private String author;
    private Double price;
}
