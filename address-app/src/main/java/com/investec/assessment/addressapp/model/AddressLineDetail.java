package com.investec.assessment.addressapp.model;

public class AddressLineDetail {
    private String line1;
    private String line2;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressLineDetail [line1=" + line1 + ", line2=" + line2 + "]";
	}

    
}
