package com.investec.assessment.addressapp.model;

public enum AddressTypeCategory {
    POSTAL("1"),
    PHYSICAL("2"),
    BUSINESS("3");

    AddressTypeCategory(String code){
        this.code = code;

    }

    private String code;
    public String getCode() {
        return code;
    }

}
