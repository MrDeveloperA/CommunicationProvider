package com.example.communicationprovider.service;

import com.example.communicationprovider.entity.*;
import com.example.communicationprovider.entity.enums.RoleNames;
import com.example.communicationprovider.payload.ApiResponse;
import com.example.communicationprovider.payload.LoginDto;
import com.example.communicationprovider.payload.RegisterDto;
import com.example.communicationprovider.payload.UserDto;
import com.example.communicationprovider.repository.*;
import com.example.communicationprovider.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    TariffRepository tariffRepository;
    @Autowired
    PackageServiceRepository packageServiceRepository;


    //      Create
    public ApiResponse addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());

        Optional<Address> optionalAddress = addressRepository.findById(userDto.getAddress());
        if (!optionalAddress.isPresent())
            return new ApiResponse("Such address was not found", false);
        user.setAddress(optionalAddress.get());

        Optional<Tariff> optionalTariff = tariffRepository.findById(userDto.getTariff());
        if (!optionalTariff.isPresent())
            return new ApiResponse("Such tariff was not found", false);
        user.setTariff(optionalTariff.get());

        user.setBalance(100000);

        Optional<PackageService> optionalPackageService = packageServiceRepository.findById(userDto.getPackageService());
        if (!optionalPackageService.isPresent())
            return new ApiResponse("Such tariff was not found", false);
        user.setPackageService((Set<PackageService>) optionalPackageService.get());


        userRepository.save(user);
        return new ApiResponse("Saved successfully", true);
    }

    //  Get
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //    Get by id
    public User getUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return null;
        return optionalUser.get();
    }

    //    Update
    public ApiResponse editUser(UUID id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return new ApiResponse("Such User was not found", false);
        User editUser = optionalUser.get();
        editUser.setFirstName(userDto.getFirstName());
        editUser.setLastName(userDto.getLastName());
        editUser.setBirthDate(userDto.getBirthDate());

        Optional<Address> optionalAddress = addressRepository.findById(userDto.getAddress());
        if (!optionalAddress.isPresent())
            return new ApiResponse("Such address was not found", false);
        editUser.setAddress(optionalAddress.get());

        editUser.setBalance(100000);

        Optional<Tariff> optionalTariff = tariffRepository.findById(userDto.getTariff());
        if (!optionalTariff.isPresent())
            return new ApiResponse("Such tariff was not found", false);
        editUser.setTariff(optionalTariff.get());

        editUser.setBalance((int) (editUser.getBalance()-editUser.getTariff().getExchangePrice()));

        Optional<PackageService> optionalPackageService = packageServiceRepository.findById(userDto.getPackageService());
        if (!optionalPackageService.isPresent())
            return new ApiResponse("Such tariff was not found", false);
        editUser.setPackageService((Set<PackageService>) optionalPackageService.get());

        userRepository.save(editUser);
        return new ApiResponse("Saved successfully", true);
    }

    //     Delete
    public ApiResponse deleteUser(UUID id) {
        try {
            userRepository.deleteById(id);
            return new ApiResponse("User was deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Error in deleting", false);
        }
    }
}
