package com.investec.assessment.addressapp;


import java.util.List;

import com.investec.assessment.addressapp.model.Address;
import com.investec.assessment.addressapp.model.AddressType;

public interface AddressService {
    String prettyPrintAddress(Address address) ;
    boolean isValid(Address address) throws Exception;
    void prettyPrintAllAddressesInFile(List<Address> addrList) ;
    void printAddressOfType(AddressType addressType, List<Address> addrList);
}
