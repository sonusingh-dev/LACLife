package com.laclife.model.calculatequote;

import java.util.List;

import com.laclife.model.LifefitBaseModel;

public class CalculateQuoteResponse extends LifefitBaseModel {

	private String quoteNo;
	private List<QuoteDataModel> quoteDataList;

	public String getQuoteNo() {
		return quoteNo;
	}

	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	public List<QuoteDataModel> getQuoteDataList() {
		return quoteDataList;
	}

	public void setQuoteDataList(List<QuoteDataModel> quoteDataList) {
		this.quoteDataList = quoteDataList;
	}

}
