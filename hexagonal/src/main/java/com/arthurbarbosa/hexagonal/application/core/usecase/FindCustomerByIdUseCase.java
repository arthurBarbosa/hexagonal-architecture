package com.arthurbarbosa.hexagonal.application.core.usecase;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }


    @Override
    public Customer findById(String id) {
        return findCustomerByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
