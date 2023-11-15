package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.service.MappingService;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import com.example.mygithubapi.repo.domain.service.MyGithubService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Log4j2
@RequestMapping("/api")
public class RestController {

    private final MyGithubService myGithubService;

    private final MappingService mappingService;

    public RestController(MyGithubService myGithubService, MappingService mappingService) {
        this.myGithubService = myGithubService;
        this.mappingService = mappingService;
    }

    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<GetRepositoriesResponseDto>> getUserRepositories(@PathVariable String username) {
        List<GetRepositoriesResponseDto> repositories = myGithubService.getUserRepositories(username);
        return ResponseEntity.ok(repositories);
    }

    @GetMapping("/branches/{owner}/{repo}")
    public ResponseEntity<List<GetBranchesResponseDto>> getRepositoryBranches(
            @PathVariable String owner,
            @PathVariable String repo
    ) {
        List<GetBranchesResponseDto> branches = myGithubService.getRepositoryBranches(owner, repo);
        return ResponseEntity.ok(branches);
    }
}
