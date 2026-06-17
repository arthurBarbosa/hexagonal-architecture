package com.arthurbarbosa.hexagonal.application.core.usecase;

import com.arthurbarbosa.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdInputPort deleteCustomerByIdInputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.findById(id);
        deleteCustomerByIdInputPort.delete(id);
    }
}
