package com.laclife.net;

import java.util.List;

import android.util.Log;

import com.laclife.parser.CalculateQuoteParser;
import com.laclife.parser.LifefitBaseParser;

public class CalculateQuoteWS extends LifefitBaseWS {

	private static final String SOAP_ACTION = "calculateQuote";

	private String agentNo;
	private String premiumFrequency;
	private String maturityYears;

	private Owner owner;
	private List<CoverageData> coverageDataList;

	public CalculateQuoteWS() {

	}

	public CalculateQuoteWS(String agentNo, String premiumFrequency,
			String maturityYears, Owner owner,
			List<CoverageData> coverageDataList) {
		this.agentNo = agentNo;
		this.premiumFrequency = premiumFrequency;
		this.maturityYears = maturityYears;
		this.owner = owner;
		this.coverageDataList = coverageDataList;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<CoverageData> getCoverageDataList() {
		return coverageDataList;
	}

	public void setCoverageDataList(List<CoverageData> coverageDataList) {
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
				+ "<fittype:AgentNo>" + getAgentNo() + "</fittype:AgentNo>"
				+ formatOwner() + "<fittype:PremiumFrequency>"
				+ getPremiumFrequency() + "</fittype:PremiumFrequency>"
				+ "<fittype:MaturityYears>" + getMaturityYears()
				+ "</fittype:MaturityYears>" + formatCoverageData()
				+ "</fittype:QuoteDataRequest>" + TAG_END;

		Log.e("LAC", "request: " + request);

		return request;
	}

	private String formatOwner() {

		String owner = null;
		if (getOwner() == null) {
			return owner = "";
		}

		owner = "<fittype:Owner>" + "<fittype:IsCompany>"
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

		return owner;
	}

	private String formatCoverageData() {

		String coverageData = "";

		List<CoverageData> coverageDataList = getCoverageDataList();
		if (coverageDataList == null || coverageDataList.isEmpty()) {
			return coverageData;
		}

		for (CoverageData data : coverageDataList) {
			coverageData = coverageData + "<fittype:CoverageData>"
					+ "<fittype:ProductCode>" + data.getProductCode()
					+ "</fittype:ProductCode>" + "<fittype:PremiumAmount>"
					+ data.getPremiumAmount() + "</fittype:PremiumAmount>"
					+ "<fittype:FaceAmount>" + data.getFaceAmount()
					+ "</fittype:FaceAmount>" + "</fittype:CoverageData>";
		}

		return coverageData;
	}

	public static class Owner {

		private boolean isCompany;

		private String lastName;
		private String firstName;
		private String middleName;
		private String natInsNo;
		private String occupationCode;
		private String occupation;
		private String email;
		private String birthDate;
		private String gender;
		private String employmentStatus;
		private String employerName;
		private String title;
		private String salutation;
		private String nationality;
		private String homePhoneNo;
		private String mobilePhoneNo;
		private String businessPhoneNo;
		private String faxNo;
		private String idNumber;
		private String idIssueDate;
		private String idIssuePlace;
		private String idExpiryDate;
		private String taxNumber;

		public boolean isCompany() {
			return isCompany;
		}

		public void setCompany(boolean isCompany) {
			this.isCompany = isCompany;
		}

		public String getLastName() {
			if (lastName == null) {
				return lastName = "";
			}
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			if (firstName == null) {
				return firstName = "";
			}
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			if (middleName == null) {
				return middleName = "";
			}
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getNatInsNo() {
			if (natInsNo == null) {
				return natInsNo = "";
			}
			return natInsNo;
		}

		public void setNatInsNo(String natInsNo) {
			this.natInsNo = natInsNo;
		}

		public String getOccupationCode() {
			if (occupationCode == null) {
				return occupationCode = "";
			}
			return occupationCode;
		}

		public void setOccupationCode(String occupationCode) {
			this.occupationCode = occupationCode;
		}

		public String getOccupation() {
			if (occupation == null) {
				return occupation = "";
			}
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public String getEmail() {
			if (email == null) {
				return email = "";
			}
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBirthDate() {
			if (birthDate == null) {
				return birthDate = "";
			}
			return birthDate;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		public String getGender() {
			if (gender == null) {
				return gender = "";
			}
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getEmploymentStatus() {
			if (employmentStatus == null) {
				return employmentStatus = "";
			}
			return employmentStatus;
		}

		public void setEmploymentStatus(String employmentStatus) {
			this.employmentStatus = employmentStatus;
		}

		public String getEmployerName() {
			if (employerName == null) {
				return employerName = "";
			}
			return employerName;
		}

		public void setEmployerName(String employerName) {
			this.employerName = employerName;
		}

		public String getTitle() {
			if (title == null) {
				return title = "";
			}
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSalutation() {
			if (salutation == null) {
				return salutation = "";
			}
			return salutation;
		}

		public void setSalutation(String salutation) {
			this.salutation = salutation;
		}

		public String getNationality() {
			if (nationality == null) {
				return nationality = "";
			}
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		public String getHomePhoneNo() {
			if (homePhoneNo == null) {
				return homePhoneNo = "";
			}
			return homePhoneNo;
		}

		public void setHomePhoneNo(String homePhoneNo) {
			this.homePhoneNo = homePhoneNo;
		}

		public String getMobilePhoneNo() {
			if (mobilePhoneNo == null) {
				return mobilePhoneNo = "";
			}
			return mobilePhoneNo;
		}

		public void setMobilePhoneNo(String mobilePhoneNo) {
			this.mobilePhoneNo = mobilePhoneNo;
		}

		public String getBusinessPhoneNo() {
			if (businessPhoneNo == null) {
				return businessPhoneNo = "";
			}
			return businessPhoneNo;
		}

		public void setBusinessPhoneNo(String businessPhoneNo) {
			this.businessPhoneNo = businessPhoneNo;
		}

		public String getFaxNo() {
			if (faxNo == null) {
				return faxNo = "";
			}
			return faxNo;
		}

		public void setFaxNo(String faxNo) {
			this.faxNo = faxNo;
		}

		public String getIdNumber() {
			if (idNumber == null) {
				return idNumber = "";
			}
			return idNumber;
		}

		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
		}

		public String getIdIssueDate() {
			if (idIssueDate == null) {
				return idIssueDate = "";
			}
			return idIssueDate;
		}

		public void setIdIssueDate(String idIssueDate) {
			this.idIssueDate = idIssueDate;
		}

		public String getIdIssuePlace() {
			if (idIssuePlace == null) {
				return idIssuePlace = "";
			}
			return idIssuePlace;
		}

		public void setIdIssuePlace(String idIssuePlace) {
			this.idIssuePlace = idIssuePlace;
		}

		public String getIdExpiryDate() {
			if (idExpiryDate == null) {
				return idExpiryDate = "";
			}
			return idExpiryDate;
		}

		public void setIdExpiryDate(String idExpiryDate) {
			this.idExpiryDate = idExpiryDate;
		}

		public String getTaxNumber() {
			if (taxNumber == null) {
				return taxNumber = "";
			}
			return taxNumber;
		}

		public void setTaxNumber(String taxNumber) {
			this.taxNumber = taxNumber;
		}
	}

	public static class CoverageData {

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

}
