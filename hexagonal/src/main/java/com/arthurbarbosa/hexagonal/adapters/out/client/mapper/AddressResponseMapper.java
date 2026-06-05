package com.arthurbarbosa.hexagonal.adapters.out.client.mapper;

import com.arthurbarbosa.hexagonal.adapters.out.client.response.AddressResponse;
import com.arthurbarbosa.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
