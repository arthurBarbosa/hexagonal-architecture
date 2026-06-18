package com.arthurbarbosa.hexagonal.config;

import com.arthurbarbosa.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arthurbarbosa.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arthurbarbosa.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.arthurbarbosa.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.arthurbarbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arthurbarbosa.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.arthurbarbosa.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {
        return new InsertCustomerUseCase(
                findAddressByZipCodeOutputPort,
                insertCustomerOutputPort,
                sendCpfForValidationOutputPort);
    }
}