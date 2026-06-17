package com.arthurbarbosa.hexagonal.application.core.usecase;

import com.arthurbarbosa.hexagonal.application.core.domain.Address;
import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.arthurbarbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.arthurbarbosa.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;


    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.findById(customer.getId());
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
