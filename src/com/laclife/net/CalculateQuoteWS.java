package com.laclife.net;

import java.util.List;

import android.util.Log;

import com.laclife.model.calculatequote.CalculateQuoteModel;
import com.laclife.model.calculatequote.CoverageDataModel;
import com.laclife.model.calculatequote.OwnerModel;
import com.laclife.parser.CalculateQuoteParser;
import com.laclife.parser.LifefitBaseParser;

public class CalculateQuoteWS extends LifefitBaseWS {

	private static final String SOAP_ACTION = "calculateQuote";

	private String agentNo;
	private String premiumFrequency;
	private String maturityYears;

	private OwnerModel owner;
	private CalculateQuoteModel calculateQuote;
	private List<CoverageDataModel> coverageDataList;

	public CalculateQuoteWS() {

	}

	public CalculateQuoteWS(String agentNo, String premiumFrequency,
			String maturityYears, OwnerModel owner,
			List<CoverageDataModel> coverageDataList) {
		this.agentNo = agentNo;
		this.premiumFrequency = premiumFrequency;
		this.maturityYears = maturityYears;
		this.owner = owner;
		this.coverageDataList = coverageDataList;
	}

	public CalculateQuoteModel getCalculateQuote() {
		return calculateQuote;
	}

	public void setCalculateQuote(CalculateQuoteModel calculateQuote) {
		this.calculateQuote = calculateQuote;
	}

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

	@Override
	public void getDataInBackground(final GetDataCallBack getDataCallBack) {
		LifefitBaseParser parser = new CalculateQuoteParser();
		new GetDataTask(parser, getDataCallBack).execute(new String[] {
				SOAP_ACTION, formatRequest() });
	}

	@Override
	public String formatRequest() {

		String request = TAG_START + "<fittype:QuoteDataRequest>" + TAG_LOGIN
				+ formatOwner() + "<fittype:AgentNo>" + getAgentNo()
				+ "</fittype:AgentNo>" + "<fittype:PremiumFrequency>"
				+ getPremiumFrequency() + "</fittype:PremiumFrequency>"
				+ "<fittype:MaturityYears>" + getMaturityYears()
				+ "</fittype:MaturityYears>" + formatCoverageData()
				+ "</fittype:QuoteDataRequest>" + TAG_END;

		Log.e("LAC", "request: " + request);

		return request;
	}

	private String formatCalculateQuote() {
		
		String request = "";
		if (calculateQuote == null) {
			return request;
		}

		request = "<fittype:AgentNo>" + calculateQuote.getAgentNo()
				+ "</fittype:AgentNo>" + "<fittype:PremiumFrequency>"
				+ calculateQuote.getPremiumFrequency()
				+ "</fittype:PremiumFrequency>" + "<fittype:MaturityYears>"
				+ calculateQuote.getMaturityYears()
				+ "</fittype:MaturityYears>";

		return request;
	}

	private String formatOwner() {

		String request = "";
		if (getOwner() == null) {
			return request;
		}

		request = "<fittype:Owner>" + "<fittype:IsCompany>"
				+ getOwner().isCompany() + "</fittype:IsCompany>"
				+ "<fittype:LastName>" + getOwner().getLastName()
				+ "</fittype:LastName>" + "<fittype:FirstName>"
				+ getOwner().getFirstName() + "</fittype:FirstName>"
				+ "<fittype:MiddleName>" + getOwner().getMiddleName()
				+ "</fittype:MiddleName>" + "<fittype:NatInsNo>"
				+ getOwner().getNatInsNo() + "</fittype:NatInsNo>"
				+ "<fittype:OccupationCode>" + getOwner().getOccupationCode()
				+ "</fittype:OccupationCode>" + "<fittype:Occupation>"
				+ getOwner().getOccupation() + "</fittype:Occupation>"
				+ "<fittype:Email>" + getOwner().getEmail()
				+ "</fittype:Email>" + "<fittype:BirthDate>"
				+ getOwner().getBirthDate() + "</fittype:BirthDate>"
				+ "<fittype:Gender>" + getOwner().getGender()
				+ "</fittype:Gender>" + "<fittype:EmploymentStatus>"
				+ getOwner().getEmploymentStatus()
				+ "</fittype:EmploymentStatus>" + "<fittype:EmployerName>"
				+ getOwner().getEmployerName() + "</fittype:EmployerName>"
				+ "<fittype:Title>" + getOwner().getTitle()
				+ "</fittype:Title>" + "<fittype:Salutation>"
				+ getOwner().getSalutation() + "</fittype:Salutation>"
				+ "<fittype:Nationality>" + getOwner().getNationality()
				+ "</fittype:Nationality>" + "<fittype:HomePhoneNo>"
				+ getOwner().getHomePhoneNo() + "</fittype:HomePhoneNo>"
				+ "<fittype:MobilePhoneNo>" + getOwner().getMobilePhoneNo()
				+ "</fittype:MobilePhoneNo>" + "<fittype:BusinessPhoneNo>"
				+ getOwner().getBusinessPhoneNo()
				+ "</fittype:BusinessPhoneNo>" + "<fittype:FaxNo>"
				+ getOwner().getFaxNo() + "</fittype:FaxNo>"
				+ "<fittype:IdNumber>" + getOwner().getIdNumber()
				+ "</fittype:IdNumber>" + "<fittype:IdIssueDate>"
				+ getOwner().getIdIssueDate() + "</fittype:IdIssueDate>"
				+ "<fittype:IdIssuePlace>" + getOwner().getIdIssuePlace()
				+ "</fittype:IdIssuePlace>" + "<fittype:IdExpiryDate>"
				+ getOwner().getIdExpiryDate() + "</fittype:IdExpiryDate>"
				+ "<fittype:TaxNumber>" + getOwner().getTaxNumber()
				+ "</fittype:TaxNumber>" + "</fittype:Owner>";

		return request;
	}

	private String formatCoverageData() {

		String request = "";
		List<CoverageDataModel> coverageDataList = getCoverageDataList();
		if (coverageDataList == null || coverageDataList.isEmpty()) {
			return request;
		}

		for (CoverageDataModel data : coverageDataList) {
			request = request + "<fittype:CoverageData>"
					+ "<fittype:ProductCode>" + data.getProductCode()
					+ "</fittype:ProductCode>" + "<fittype:PremiumAmount>"
					+ data.getPremiumAmount() + "</fittype:PremiumAmount>"
					+ "<fittype:FaceAmount>" + data.getFaceAmount()
					+ "</fittype:FaceAmount>" + "</fittype:CoverageData>";
		}

		return request;
	}

}
