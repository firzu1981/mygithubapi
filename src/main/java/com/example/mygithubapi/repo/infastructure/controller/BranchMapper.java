package com.example.mygithubapi.repo.infastructure.controller;

import com.example.mygithubapi.repo.domain.model.Branch;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.CommitDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public static Branch mapFromGetBranchesResponseDtoToBranch(GetBranchesResponseDto dto) {
        return new Branch(dto.name(), dto.commit().sha());
    }

    public static GetBranchesResponseDto mapFromBranchToGetBranchesResponseDto(Branch branch) {
        return new GetBranchesResponseDto(branch.branchName(), new CommitDto(branch.commitSha()));
    }
}
