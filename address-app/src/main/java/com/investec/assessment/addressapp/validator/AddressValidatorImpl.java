package com.investec.assessment.addressapp.validator;

import org.apache.commons.lang3.StringUtils;
import com.investec.assessment.addressapp.model.Address;
import com.investec.assessment.addressapp.model.AddressLineDetail;
import com.investec.assessment.addressapp.model.Country;

public class AddressValidatorImpl implements AddressValidator {
    public static final String ZAMBIA = "ZA";

    @Override
    public boolean isNumericPostalCode(String postalCd) {
        if (StringUtils.isNumeric(postalCd)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAddressLineDetails(AddressLineDetail addressLineDetail) {
        if(addressLineDetail == null){
            return false;

        }else {
            if((addressLineDetail.getLine1() == null || 
            		addressLineDetail.getLine1().trim().isEmpty()) &&
                    (addressLineDetail.getLine2() == null || addressLineDetail.getLine2().trim().isEmpty())) {
                return false;
            }

            return true;
        }
    }

    @Override
    public boolean hasProvince(Address address) {
        if(ZAMBIA.equals(address.getCountry().getCode())){
            if(address.getProvinceOrState() == null){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean hasCountry(Country country) {
        if(country == null){
            return false;
        }

        return true;
    }

}
