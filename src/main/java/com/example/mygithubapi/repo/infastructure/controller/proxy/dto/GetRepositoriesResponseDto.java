package com.example.mygithubapi.repo.infastructure.controller.proxy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetRepositoriesResponseDto(String name , OwnerDto owner) {
}
