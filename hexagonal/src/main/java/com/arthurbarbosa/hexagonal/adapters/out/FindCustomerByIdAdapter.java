package com.arthurbarbosa.hexagonal.adapters.out;

import com.arthurbarbosa.hexagonal.adapters.out.repository.CustomerRepository;
import com.arthurbarbosa.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arthurbarbosa.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import com.arthurbarbosa.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> findById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
