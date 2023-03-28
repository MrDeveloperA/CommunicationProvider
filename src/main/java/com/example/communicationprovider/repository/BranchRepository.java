package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Address;
import com.example.communicationprovider.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RepositoryRestResource(path = "branch")
public interface BranchRepository extends JpaRepository<Branch, UUID> {

}

