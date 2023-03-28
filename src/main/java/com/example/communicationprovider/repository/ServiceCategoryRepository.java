package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Branch;
import com.example.communicationprovider.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RepositoryRestResource(path = "serviceCategory")
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, UUID> {

}

