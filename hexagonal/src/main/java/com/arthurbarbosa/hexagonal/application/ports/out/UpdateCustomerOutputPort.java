package com.arthurbarbosa.hexagonal.application.ports.out;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
