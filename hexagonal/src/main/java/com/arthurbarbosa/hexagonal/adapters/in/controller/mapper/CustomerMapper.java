package com.arthurbarbosa.hexagonal.adapters.in.controller.mapper;

import com.arthurbarbosa.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest request);
}
