package com.example.mygithubapi.getfromgithubclient.services;

import com.example.mygithubapi.getfromgithubclient.proxy.MyGithubProxy;
import com.example.mygithubapi.getfromgithubclient.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.getfromgithubclient.proxy.dto.GetRepositoriesResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyGithubService {
    private final MyGithubProxy myGithubProxy;

    public MyGithubService(MyGithubProxy myGithubProxy) {
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
