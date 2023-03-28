package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Address;
import com.example.communicationprovider.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, UUID> {

}

