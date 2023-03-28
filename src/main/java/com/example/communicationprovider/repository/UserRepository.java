package com.example.communicationprovider.repository;

import com.example.communicationprovider.entity.Employee;
import com.example.communicationprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface UserRepository extends JpaRepository<User, UUID> {

}

