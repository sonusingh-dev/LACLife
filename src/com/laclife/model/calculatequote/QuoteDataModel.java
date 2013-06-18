package com.laclife.model.calculatequote;

import com.laclife.model.BaseModel;

public class QuoteDataModel implements BaseModel {

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
