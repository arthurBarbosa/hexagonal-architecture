package com.arthurbarbosa.hexagonal.adapters.out;

import com.arthurbarbosa.hexagonal.adapters.out.repository.CustomerRepository;
import com.arthurbarbosa.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import com.arthurbarbosa.hexagonal.application.ports.out.InsertCustomerOutPut;
import com.arthurbarbosa.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var entity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(entity);
    }
}
