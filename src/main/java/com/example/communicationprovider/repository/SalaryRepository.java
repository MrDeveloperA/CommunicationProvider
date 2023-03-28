package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "salary")
public interface SalaryRepository extends JpaRepository<Salary, UUID> {

}
