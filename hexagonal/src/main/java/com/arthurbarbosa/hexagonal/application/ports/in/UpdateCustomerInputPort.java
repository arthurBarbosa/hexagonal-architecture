package com.arthurbarbosa.hexagonal.application.ports.in;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
