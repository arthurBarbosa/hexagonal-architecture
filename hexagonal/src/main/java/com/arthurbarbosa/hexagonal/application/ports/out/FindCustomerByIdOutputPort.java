package com.arthurbarbosa.hexagonal.application.ports.out;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);

}
