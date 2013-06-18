package com.laclife.model;

import java.util.List;

public class CalculateQuoteResponse extends LifefitBaseModel {

	private String quoteNo;
	private List<QuoteDataModel> quoteData;

	public String getQuoteNo() {
		return quoteNo;
	}

	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	public List<QuoteDataModel> getQuoteData() {
		return quoteData;
	}

	public void setQuoteData(List<QuoteDataModel> quoteData) {
		this.quoteData = quoteData;
	}

}
