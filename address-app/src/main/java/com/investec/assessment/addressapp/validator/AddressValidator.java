package com.investec.assessment.addressapp.validator;

import com.investec.assessment.addressapp.model.Address;
import com.investec.assessment.addressapp.model.AddressLineDetail;
import com.investec.assessment.addressapp.model.Country;

public interface AddressValidator {
    boolean isNumericPostalCode(String postalCd) ;
    boolean hasAddressLineDetails(AddressLineDetail addressLineDetail) ;
    boolean hasProvince(Address address) ;
    boolean hasCountry(Country country) ;
}
