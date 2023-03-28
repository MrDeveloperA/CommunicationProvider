package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.IDCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RepositoryRestResource(path = "idCard")
public interface IDCardRepository extends JpaRepository<IDCard, UUID> {

}

