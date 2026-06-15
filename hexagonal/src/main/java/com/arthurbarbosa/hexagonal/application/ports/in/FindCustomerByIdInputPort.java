package com.arthurbarbosa.hexagonal.application.ports.in;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findById(String id);
}
