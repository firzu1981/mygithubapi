package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.model.Branch;
import com.example.mygithubapi.repo.domain.model.NotAcceptableException;
import com.example.mygithubapi.repo.domain.model.Repo;
import com.example.mygithubapi.repo.domain.service.RetrievingService;
import com.example.mygithubapi.repo.domain.model.UsernameNotFoundException;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final RetrievingService retrievingService;
    private final RepoMapper repoMapper;
    private final BranchMapper branchMapper;

    public RestController(RetrievingService retrievingService, RepoMapper repoMapper, BranchMapper branchMapper) {
        this.retrievingService = retrievingService;
        this.repoMapper = repoMapper;
        this.branchMapper = branchMapper;
    }

    @GetMapping(value = "/repositories/{username}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Repo>> getUserRepositories(@PathVariable String username) {
        List<GetRepositoriesResponseDto> responseDtos = retrievingService.fetchAllRepos(username);
        if (responseDtos == null || responseDtos.isEmpty()) {
            try {
                throw new UsernameNotFoundException("Username not found");
            } catch (UsernameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        List<Repo> repos = repoMapper.mapToRepoList(responseDtos);
        return ResponseEntity.ok(repos);
    }

    @GetMapping(value = "/branches/{owner}/{repo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Branch>> getRepositoryBranches(
            @PathVariable String owner,
            @PathVariable String repo
    ) {
        List<GetBranchesResponseDto> branchDtos = retrievingService.getRepositoryBranches(owner, repo);
        if (branchDtos == null || branchDtos.isEmpty()){
            try {
                throw new NotAcceptableException("Not acceptable media type");
            } catch (NotAcceptableException e) {
                throw new RuntimeException(e);
            }
        }
        List<Branch> branches = branchMapper.mapToBranchList(branchDtos);
        return ResponseEntity.ok(branches);
    }
}
