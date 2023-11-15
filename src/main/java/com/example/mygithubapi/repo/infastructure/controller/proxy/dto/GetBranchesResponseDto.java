package com.example.mygithubapi.repo.infastructure.controller.proxy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetBranchesResponseDto(String name,CommitDto commit) {

}
