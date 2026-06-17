package com.arthurbarbosa.hexagonal.adapters.in.controller;

import com.arthurbarbosa.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arthurbarbosa.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arthurbarbosa.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController extends BaseController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMapper customerMapper;

    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            UpdateCustomerInputPort updateCustomerInputPort,
            CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {

        final var customer = customerMapper.toCustomer(request);
        insertCustomerInputPort.insert(customer, request.getZipCode());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.findById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest request) {
        var customer = customerMapper.toCustomer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }
}
