package com.example.firstservice.exception.not_found;

import com.example.commonservice.exception.not_found.ResourceNotFoundException;

public class AddressNotFoundException extends ResourceNotFoundException {
    public AddressNotFoundException(Integer addressId) {
        super("Adress", "address-id", addressId.toString());
    }

    public AddressNotFoundException(String street, String zipCode) {
        super("Address", "address-street, address-zipcode", street + ", " + zipCode);
    }
}
