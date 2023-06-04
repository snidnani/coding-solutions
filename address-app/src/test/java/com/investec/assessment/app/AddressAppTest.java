package com.investec.assessment.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.investec.assessment.addressapp.AddressService;
import com.investec.assessment.addressapp.AddressServiceImpl;
import com.investec.assessment.addressapp.model.Address;
import com.investec.assessment.addressapp.model.AddressType;
import com.investec.assessment.addressapp.model.AddressTypeCategory;

/**
 * Unit test for AddressAppTest for address validation with positive and negative scenarios.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressAppTest {
    List<Address> addresses;
    AddressService addressService;
    public AddressAppTest() {
    }

    @BeforeAll
    public void loadAddressesFromFile() throws Exception {
        addressService = new AddressServiceImpl();
        addresses = (List<Address>) getAddressesFromFile("addresses.json");
    }

	@Test
	public void testPrettyPrintAddress(){
	    System.out.println(addressService.prettyPrintAddress(addresses.get(0)));
	}
	
	@Test
	public void testIsValidAddressess()  {
	    for (Address address : addresses) {
	        try {
	            addressService.isValid(address);
	        } catch (Exception e) {
	            System.out.println("Address with id " + address.getId() + "  has an error : " + e.getMessage());
	        }
	    }
	}
	
	@Test
	public void testPrettyPrintAllAddressesInFile(){
	    addressService.prettyPrintAllAddressesInFile(addresses);
	}
	
	@Test
	public void testPrintAddressOfType(){
	    AddressType addressType = new AddressType();
	    addressType.setCode(AddressTypeCategory.PHYSICAL.getCode());
	    addressService.printAddressOfType(addressType,addresses);
	}
	
	private Collection<Address> getAddressesFromFile(String fileName) throws Exception {
	
	    ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource(fileName).getFile());
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
	    Gson gson = new Gson();
	    Type collectionType = new TypeToken<Collection<Address>>(){}.getType();
	    Collection<Address> addressList = gson.fromJson(bufferedReader, collectionType);
	    return addressList;
	
	}
}
