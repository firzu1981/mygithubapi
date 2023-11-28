package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.model.Branch;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface BranchMapper {

    @Mapping(source = "name", target = "branchName")
    @Mapping(source = "commit.sha", target = "commitSha")
    Branch mapGetBranchDtoToBranch(GetBranchesResponseDto getBranchesResponseDto);

    List<Branch> mapToBranchList(List<GetBranchesResponseDto> dtos);

}
