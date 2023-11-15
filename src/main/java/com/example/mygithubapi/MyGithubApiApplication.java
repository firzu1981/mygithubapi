package com.example.mygithubapi;

import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetBranchesResponseDto;
import com.example.mygithubapi.repo.infastructure.controller.proxy.dto.GetRepositoriesResponseDto;
import com.example.mygithubapi.repo.domain.service.MyGithubService;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class MyGithubApiApplication {

    private final MyGithubService myGithubService;

    public MyGithubApiApplication(MyGithubService myGithubService) {
        this.myGithubService = myGithubService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyGithubApiApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
            List<GetRepositoriesResponseDto> responseRepos = myGithubService.fetchAllRepos("kalqa");
            log.info(responseRepos);
            List<GetBranchesResponseDto> responseBranches = myGithubService.fetchAllBranches("kalqa", "03-restemplate");
            log.info(responseBranches);
        } catch (FeignException.FeignClientException feignException) {
            log.error("client exception: " + feignException.status());
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

