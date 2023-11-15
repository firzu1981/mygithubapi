package com.example.mygithubapi.repo.domain.model;

import org.springframework.stereotype.Component;


public record Branch(String branchName, String commitSha) {
}
