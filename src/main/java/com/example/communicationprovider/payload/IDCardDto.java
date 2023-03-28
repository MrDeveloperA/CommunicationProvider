package com.example.communicationprovider.payload;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.UUID;

@Data
public class IDCardDto {
    @NotNull
    @Email
    private UUID username;//email
}
