package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.service.RetrievingService;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@Log4j2
@RequestMapping("/api")
public class RestController {

    private final RetrievingService retrievingService;
    private final BranchMapper branchMapper;
    private final RepoMapper repoMapper;

    public RestController(RetrievingService retrievingService, BranchMapper branchMapper, RepoMapper repoMapper) {
        this.retrievingService = retrievingService;
        this.branchMapper = branchMapper;
        this.repoMapper = repoMapper;
    }

    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<GetRepositoriesResponseDto>> getUserRepositories(@PathVariable String username) {
        List<GetRepositoriesResponseDto> repositories = retrievingService.getUserRepositories(username);
        return ResponseEntity.ok(repositories);
    }

    @GetMapping("/branches/{owner}/{repo}")
    public ResponseEntity<List<GetBranchesResponseDto>> getRepositoryBranches(
            @PathVariable String owner,
            @PathVariable String repo
    ) {
        List<GetBranchesResponseDto> branches = retrievingService.getRepositoryBranches(owner, repo);
        return ResponseEntity.ok(branches);
    }
}
