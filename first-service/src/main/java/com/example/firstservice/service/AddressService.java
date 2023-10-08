package com.example.firstservice.service;

import com.example.firstservice.entity.Address;
import com.example.firstservice.exception.not_found.AddressNotFoundException;
import com.example.commonservice.model.AddressDTO;
import com.example.firstservice.repository.AddressRepository;
import com.example.firstservice.util.mappers.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressService(
            AddressRepository addressRepository,
            AddressMapper addressMapper
    ) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address getAddressById(Integer addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(addressId));
    }

    public Address findAddressByStreetAndZipCode(String street, String zipCode) {
        Address address = addressRepository.findAddressByStreetAndZipCode(street, zipCode);
        if (address == null) throw new AddressNotFoundException(street, zipCode);
        return address;
    }

    public Address addAddress(AddressDTO addressDTO) {
        return addressRepository.save(addressMapper.fromDTO(addressDTO));
    }

    public void deleteAddress(Integer id) {
        getAddressById(id);
        addressRepository.deleteById(id);
    }
}
