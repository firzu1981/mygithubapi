package com.example.mygithubapi;

import com.example.mygithubapi.repo.domain.service.RetrievingService;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@SpringBootApplication
@EnableFeignClients

public class MyGithubApiApplication {

    private final RetrievingService retrievingService;

    public MyGithubApiApplication(RetrievingService retrievingService) {
        this.retrievingService = retrievingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyGithubApiApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        Logger logger = LoggerFactory.getLogger(MyGithubApiApplication.class);
        try {
            List<GetRepositoriesResponseDto> responseRepos = retrievingService.fetchAllRepos("kalqa");
            logger.info(responseRepos.toString());
            List<GetBranchesResponseDto> responseBranches = retrievingService.fetchAllBranches("kalqa", "03-restemplate");
            logger.info(responseBranches.toString());
        } catch (FeignException.FeignClientException feignException) {
            logger.error("client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            System.out.println("server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            System.out.println("retryable exception " + retryableException.getMessage());
        } catch (FeignException feignException) {
            System.out.println(feignException.getMessage());
            System.out.println(feignException.status());
        }
    }
}

