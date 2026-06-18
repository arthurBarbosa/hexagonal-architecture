package com.arthurbarbosa.hexagonal.config;

import com.arthurbarbosa.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arthurbarbosa.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arthurbarbosa.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.arthurbarbosa.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}