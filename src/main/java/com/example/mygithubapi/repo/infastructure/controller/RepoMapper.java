package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.model.Repo;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.OwnerDto;
import org.springframework.stereotype.Component;

@Component
public class RepoMapper {
    public Repo mapFromGetRepositoriesResponseDtoToRepo(GetRepositoriesResponseDto dto) {
        return new Repo(dto.name(), dto.owner().login());
    }

    public static GetRepositoriesResponseDto mapFromRepoToGetRepositoriesResponseDto(Repo repo) {
        return new GetRepositoriesResponseDto(repo.repoName(), new OwnerDto(repo.ownerLogin()));
    }
}
