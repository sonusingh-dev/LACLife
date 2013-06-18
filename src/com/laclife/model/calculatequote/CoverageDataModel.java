package com.laclife.model.calculatequote;

import com.laclife.model.BaseModel;

public class CoverageDataModel implements BaseModel {

	private static final long serialVersionUID = 1L;

	private String productCode;
	private String premiumAmount;
	private String faceAmount;

	public String getProductCode() {
		if (productCode == null) {
			return productCode = "";
		}
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPremiumAmount() {
		if (premiumAmount == null) {
			return premiumAmount = "";
		}
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getFaceAmount() {
		if (faceAmount == null) {
			return faceAmount = "";
		}
		return faceAmount;
	}

	public void setFaceAmount(String faceAmount) {
		this.faceAmount = faceAmount;
	}
}