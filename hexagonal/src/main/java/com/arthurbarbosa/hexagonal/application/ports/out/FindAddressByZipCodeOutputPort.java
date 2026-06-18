package com.arthurbarbosa.hexagonal.application.ports.out;

import com.arthurbarbosa.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
