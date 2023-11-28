package com.example.mygithubapi.repo.config;

import com.example.mygithubapi.repo.infastructure.controller.BranchMapper;
import com.example.mygithubapi.repo.infastructure.controller.RepoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public RepoMapper repoMapper() {
        return Mappers.getMapper(RepoMapper.class);
    }

    @Bean
    public BranchMapper branchMapper() {
        return Mappers.getMapper(BranchMapper.class);
    }
}