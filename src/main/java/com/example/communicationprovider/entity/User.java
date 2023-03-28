package com.example.communicationprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Date birthDate;
    @OneToOne
    private Address address;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;//qachon ro'yxatdan o'tganligi
    @UpdateTimestamp
    private Timestamp updatedAt;//ohirgi marta qachon tahrirlanganligi

    @OneToOne
    private Tariff tariff;

    @Column(nullable = false)
    private Integer balance;

    @OneToMany
    private Set<PackageService> packageService;
}
