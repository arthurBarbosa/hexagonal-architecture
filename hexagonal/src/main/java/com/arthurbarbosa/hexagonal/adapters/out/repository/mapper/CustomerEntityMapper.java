package com.arthurbarbosa.hexagonal.adapters.out.repository.mapper;

import com.arthurbarbosa.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

}
