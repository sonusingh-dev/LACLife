package com.laclife;

import android.app.Application;

public class LACLifeApplication extends Application {

	public String product;
	public String productQuote;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductQuote() {
		return productQuote;
	}
	
	public void setProductQuote() {
		this.productQuote = product + " Quote";
	}

	public void setProductQuote(String productQuote) {
		this.productQuote = productQuote + " Quote";
	}

}
