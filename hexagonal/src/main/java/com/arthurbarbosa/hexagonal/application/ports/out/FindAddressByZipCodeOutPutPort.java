package com.arthurbarbosa.hexagonal.application.ports.out;

import com.arthurbarbosa.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPutPort {

    Address find(String zipCode);

}
