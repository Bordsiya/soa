package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.Address;
import com.example.commonservice.model.AddressDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper {
    public Address fromDTO(AddressDTO addressDTO) {
        return new Address(
                0,
                addressDTO.getStreet(),
                addressDTO.getZipCode(),
                List.of()
        );
    }
}
