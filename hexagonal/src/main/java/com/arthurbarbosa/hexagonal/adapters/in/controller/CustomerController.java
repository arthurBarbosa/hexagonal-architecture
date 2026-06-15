package com.arthurbarbosa.hexagonal.adapters.in.controller;

import com.arthurbarbosa.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arthurbarbosa.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arthurbarbosa.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController extends BaseController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort1,
            CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort1;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {

        final var customer = customerMapper.toCustomer(request);
        insertCustomerInputPort.insert(customer, request.getZipCode());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.findById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
