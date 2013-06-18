package com.laclife.model.calculatequote;

import java.util.List;

import com.laclife.model.BaseModel;

public class CalculateQuoteModel implements BaseModel {

	private static final long serialVersionUID = 1L;

	private String agentNo;
	private String premiumFrequency;
	private String maturityYears;

	private OwnerModel owner;
	private List<CoverageDataModel> coverageDataList;

	public String getAgentNo() {
		if (agentNo == null) {
			return agentNo = "";
		}
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public String getPremiumFrequency() {
		if (premiumFrequency == null) {
			return premiumFrequency = "";
		}
		return premiumFrequency;
	}

	public void setPremiumFrequency(String premiumFrequency) {
		this.premiumFrequency = premiumFrequency;
	}

	public String getMaturityYears() {
		if (maturityYears == null) {
			return maturityYears = "";
		}
		return maturityYears;
	}

	public void setMaturityYears(String maturityYears) {
		this.maturityYears = maturityYears;
	}

	public OwnerModel getOwner() {
		return owner;
	}

	public void setOwner(OwnerModel owner) {
		this.owner = owner;
	}

	public List<CoverageDataModel> getCoverageDataList() {
		return coverageDataList;
	}

	public void setCoverageDataList(List<CoverageDataModel> coverageDataList) {
		this.coverageDataList = coverageDataList;
	}
}
