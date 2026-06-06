package com.arthurbarbosa.hexagonal.application.ports.in;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
