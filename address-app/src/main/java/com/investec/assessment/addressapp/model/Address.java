package com.investec.assessment.addressapp.model;

public class Address {
    private Country country;
    
    private ProvinceOrState provinceOrState;

    private String postalCode;

    private AddressLineDetail addressLineDetail;

    private String id;
    
    private String cityOrTown;
    
    private AddressType addressType;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ProvinceOrState getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(ProvinceOrState provinceOrState) {
        this.provinceOrState = provinceOrState;
    }
    
    public AddressType getType() {
		return addressType;
	}
    
    public void setType(AddressType addressType) {
    	this.addressType = addressType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [country=" + country  + ", provinceOrState=" + provinceOrState + ", type=" + addressType
				+ ", postalCode=" + postalCode + ", addressLineDetail=" + addressLineDetail + ", id=" + id  + ", cityOrTown=" + cityOrTown + "]";
	}

	

    
}
