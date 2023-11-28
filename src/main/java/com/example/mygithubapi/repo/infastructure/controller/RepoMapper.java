package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.model.Repo;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import org.mapstruct.Mapping;

import java.util.List;


@org.mapstruct.Mapper
public interface RepoMapper {

    @Mapping(source = "name", target = "repoName")
    @Mapping(source = "owner.login", target = "ownerLogin")
    Repo mapGetRepoDtoToRepo(GetRepositoriesResponseDto getRepositoriesResponseDto);

    List<Repo> mapToRepoList(List<GetRepositoriesResponseDto> dtos);

}