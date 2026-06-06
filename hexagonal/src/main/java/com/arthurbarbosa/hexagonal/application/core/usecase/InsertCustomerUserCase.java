package com.arthurbarbosa.hexagonal.application.core.usecase;

import com.arthurbarbosa.hexagonal.application.core.domain.Customer;
import com.arthurbarbosa.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arthurbarbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.arthurbarbosa.hexagonal.application.ports.out.InsertCustomerOutPut;

public class InsertCustomerUserCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutPut insertCustomerOutPut;

    public InsertCustomerUserCase(FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  InsertCustomerOutPut insertCustomerOutPut) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPut = insertCustomerOutPut;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPut.insert(customer);
    }
}
