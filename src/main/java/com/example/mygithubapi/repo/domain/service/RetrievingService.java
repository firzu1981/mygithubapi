package com.example.mygithubapi.repo.domain.service;


import com.example.mygithubapi.repo.infastructure.controller.proxy.MyGithubProxy;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RetrievingService {
    private final MyGithubProxy myGithubProxy;

    public RetrievingService(MyGithubProxy myGithubProxy) {
        this.myGithubProxy = myGithubProxy;
    }

    public List<GetRepositoriesResponseDto> fetchAllRepos(String username) {
        return myGithubProxy.fetchAllRepos(username);
    }

    public List<GetBranchesResponseDto> fetchAllBranches(String owner, String repo) {
        return myGithubProxy.fetchAllBranches(owner, repo);
    }
    public List<GetRepositoriesResponseDto> getUserRepositories(String username) {
        return myGithubProxy.fetchAllRepos(username);
    }

    public List<GetBranchesResponseDto> getRepositoryBranches(String owner, String repo) {
        return myGithubProxy.fetchAllBranches(owner, repo);
    }

}
