package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Branch;
import com.example.communicationprovider.entity.SIM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RepositoryRestResource(path = "sim")
public interface SIMRepository extends JpaRepository<SIM, UUID> {

}

