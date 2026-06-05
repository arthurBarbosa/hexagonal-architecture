package com.arthurbarbosa.hexagonal.application.ports.out;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutPut {

    void insert(Customer customer);

}
