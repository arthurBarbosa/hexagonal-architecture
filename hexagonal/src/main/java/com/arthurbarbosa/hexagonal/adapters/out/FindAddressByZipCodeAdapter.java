package com.arthurbarbosa.hexagonal.adapters.out;

import com.arthurbarbosa.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.arthurbarbosa.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.arthurbarbosa.hexagonal.application.core.domain.Address;
import com.arthurbarbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(
            FindAddressByZipCodeClient findAddressByZipCodeClient,
            AddressResponseMapper addressResponseMapper
    ) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
