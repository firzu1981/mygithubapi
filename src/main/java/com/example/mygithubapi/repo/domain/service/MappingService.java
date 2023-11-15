package com.example.mygithubapi.repo.domain.service;

import com.example.mygithubapi.repo.domain.model.Branch;
import com.example.mygithubapi.repo.domain.model.Repo;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.CommitDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.OwnerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    private final ModelMapper modelMapper;

    public MappingService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public GetRepositoriesResponseDto mapGetRepoToRepo(Repo repo) {
        return modelMapper.map(repo, GetRepositoriesResponseDto.class);
    }
    public OwnerDto mapOwnerDtoToRepo(Repo repo) {
        return modelMapper.map(repo, OwnerDto.class);
    }
    public GetBranchesResponseDto mapGetBranchDtoToBranch(Branch branch) {
        return modelMapper.map(branch, GetBranchesResponseDto.class);
    }
    public CommitDto mapCommitDtoToBranch(Branch branch) {
        return modelMapper.map(branch, CommitDto.class);
    }
}
