package com.investec.assessment.addressapp;

import java.util.List;
import java.util.stream.Collectors;

import com.investec.assessment.addressapp.model.Address;
import com.investec.assessment.addressapp.model.AddressType;
import com.investec.assessment.addressapp.validator.AddressValidator;
import com.investec.assessment.addressapp.validator.AddressValidatorImpl;

public class AddressServiceImpl implements AddressService {


    @Override
    public String prettyPrintAddress(Address address) {
    	
        StringBuilder sb = new StringBuilder();
        sb.append("Address Details \n");
        sb.append( address.getType().getName() + " : ");

        if(address.getAddressLineDetail() != null) {
            if (address.getAddressLineDetail().getLine1() != null && !address.getAddressLineDetail().getLine1().isEmpty())
                sb.append(address.getAddressLineDetail().getLine1() );
            if (address.getAddressLineDetail().getLine2() != null && !address.getAddressLineDetail().getLine2().isEmpty())
                sb.append("  - " + address.getAddressLineDetail().getLine2() );
        }

        sb.append(" - " + address.getCityOrTown());

        if(address.getProvinceOrState() != null)
            sb.append(" - " + address.getProvinceOrState().getName() );

        sb.append(" - " + address.getPostalCode());
        sb.append(" - " + address.getCountry().getName());

        return sb.toString();
    }

    @Override
    public boolean isValid(Address address) throws Exception {
        AddressValidator addressValidator = new AddressValidatorImpl();

        if (!addressValidator.isNumericPostalCode(address.getPostalCode())) {
            throw new Exception("Postal code must be numeric. Address Id:"+address.getId());
        }

        if (!addressValidator.hasCountry(address.getCountry())) {
            throw new Exception("Country code is required, please specify the country for the address.Address Id:"+address.getId());
        }

        if (!addressValidator.hasProvince(address)) {
            throw new Exception("Province is required for Country code ZA. Address Id:"+address.getId());
        }

        if (!addressValidator.hasAddressLineDetails(address.getAddressLineDetail())) {
            throw new Exception("Address Lines not provided for address id-"+address.getId()+", Atleast one address line must be specified");
        }

        return true;
    }


    @Override
    public void prettyPrintAllAddressesInFile(List<Address> addrList) {
        for (Address address : addrList) {
            System.out.println(prettyPrintAddress(address));
        }
    }

    @Override
    public void printAddressOfType(AddressType addressType, List<Address> addressList) {
        List<Address> filteredAddresses = null;
		
		if (addressList != null && !addressList.isEmpty()) {
			filteredAddresses = addressList.stream().
					filter(addr -> addr.getType().getCode() == addressType.getCode()).
					collect(Collectors.toList());
		}
    	
        for(Address address : filteredAddresses)
            System.out.println(prettyPrintAddress(address));        

    }

}
