package com.example.communicationprovider.payload;

import com.example.communicationprovider.entity.Address;
import com.example.communicationprovider.entity.PackageService;
import com.example.communicationprovider.entity.Tariff;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Date birthDate;
    private UUID address;

    private UUID tariff;

    private Integer balance;
    private UUID packageService;

}

