package com.example.mygithubapi.getfromgithubclient.proxy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetBranchesResponseDto(String name,CommitDto commit) {

}
