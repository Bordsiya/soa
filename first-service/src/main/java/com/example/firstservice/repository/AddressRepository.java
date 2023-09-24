package com.example.firstservice.repository;

import com.example.firstservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressByStreetAndZipCode(String street, String zipCode);
}
