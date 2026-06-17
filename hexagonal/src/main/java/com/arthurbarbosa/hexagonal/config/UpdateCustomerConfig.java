package com.arthurbarbosa.hexagonal.config;

import com.arthurbarbosa.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arthurbarbosa.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.arthurbarbosa.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.arthurbarbosa.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);

    }

}
