package com.arthurbarbosa.hexagonal.config;

import com.arthurbarbosa.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.arthurbarbosa.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.arthurbarbosa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdInputPort deleteCustomerByIdInputPort
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdInputPort);
    }
}
