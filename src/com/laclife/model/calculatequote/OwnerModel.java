package com.laclife.model.calculatequote;

import com.laclife.model.BaseModel;

public class OwnerModel implements BaseModel {

	private static final long serialVersionUID = 1L;

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
