package com.example.mygithubapi.getfromgithubclient.proxy;

import com.example.mygithubapi.getfromgithubclient.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.getfromgithubclient.proxy.dto.GetRepositoriesResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "get-from-github-client")
public interface MyGithubProxy {
    @GetMapping("/users/{username}/repos")
    List<GetRepositoriesResponseDto> fetchAllRepos(@PathVariable String username);

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<GetBranchesResponseDto> fetchAllBranches(@PathVariable String owner,
                                                  @PathVariable String repo);

}
