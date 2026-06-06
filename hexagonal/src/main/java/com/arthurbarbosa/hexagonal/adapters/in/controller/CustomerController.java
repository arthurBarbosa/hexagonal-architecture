package com.arthurbarbosa.hexagonal.adapters.in.controller;

import com.arthurbarbosa.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arthurbarbosa.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arthurbarbosa.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController extends BaseController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;

    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {

        final var customer = customerMapper.toCustomer(request);
        insertCustomerInputPort.insert(customer, request.getZipCode());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
