package com.databankgroup.gh.accopeningapi.model;

import com.databankgroup.gh.accopeningapi.validator.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@SecondApplicantDetailsCheck.List({
		@SecondApplicantDetailsCheck(first="accountType",second="title2",message="Title of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="gender2",message="Gender of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="lastName2",message="Lastname of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="firstName2",message="Firstname of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="email2",message="Email of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="dob2",message="Date Of Birth of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="country2",message="Country of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="state2",message="State of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="city2",message="City of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="postalAddress2",message="State of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="idExpiryDate2",message="ID Expiry Date of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="phoneNumber2",message="phone # of second applicant is required"),
		@SecondApplicantDetailsCheck(first="accountType",second="maritalStatus2"),
		@SecondApplicantDetailsCheck(first="accountType",second="nationality2"),
		@SecondApplicantDetailsCheck(first="accountType",second="maritalStatus2"),
		@SecondApplicantDetailsCheck(first="accountType",second="countryOfResidence2",message="Country's iso Alpha Code is required")

})
@BeneficiaryAllocationCheck
public class AppBean implements Serializable {


	private static final long serialVersionUID = -4221045095101467108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	@Transient
	@NotNull
	private MultipartFile passportImage;

	@Transient
	@NotNull
	private MultipartFile signatureImage;

	@Transient
	@NotNull
	private MultipartFile photoIDImage;

	@Transient
	@NotNull
	private MultipartFile proofOfAddressImage;

	@Column
	@NotNull

	@Size(min=2, message="last name(first applicant) should have at least 2 characters")
	private String lastName;

	@Column
	private boolean onlineServiceApplicant;

	@Column
	@NotNull
	@Size(min=2, message="first name(first applicant) should have at least 2 characters")
	private String firstName;

	@Column

	private String middleName;

	@Column
	@NotNull(message="email (first applicant) should not be null")
	@Email
	private String email;

	@Column
	private String confirmEmail;

	@Column
	@NotNull(message="phone number(first applicant) should not be null")
	private String phoneNumber;

	@Column

	@AccountType
	private String accountType;

	@Column
	@NotNull
	@TitleCheck
	private String title;

	@Column
	@NotNull
	@GenderCheck(message="gender(first applicant) should be either Male or Female")
	private String gender;


	@Column
	private String otherNames;

	@Column
	private String residentialPhone;


	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="Date of birth is required")
	private Date dob;

	@Column
	@NotNull
	private String country;

	@Column
	@NotNull
	private String state;

	@Column
	@NotNull(message="Country's iso Alpha Code is required")
	private String countryOfResidence; //use this to store country isoAlpha2Code

	@Column
	@NotNull
	private String nationality;


	@Column
	@NotNull
	private String occupation;

	@Column
	private String employerName;

	@Column
	private String levelOfEducation;

	@Column
	@NotNull
	@PhotoIDCheck
	private String photoId;

	@Column
	@NotNull
	private String idNumber;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date idExpiryDate;


	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFormCompleted;


	@Column
	private String mothersMaidenName;

	@Column

	private String annualIncome;

	@Column

	private String otherIncomeSources;

	@Column
	private String channel;

	@Column
	private String q1;

	@Column
	private String q2;

	@Column
	private String q3;

	@Column
	private String q4;

	@Column
	private String q5;
	@Column
	@NotNull(message = "Surname of first beneficiary is required")
	private String ben1Surname;
	@Column
	private String ben2Surname;
	@Column
	private String ben3Surname;
	@Column
	@NotNull(message="Beneficary 1 - firstname is required")
	private String ben1Firstname;
	@Column
	private String ben2Firstname;
	@Column
	private String ben3Firstname;
	@Column
	@NotNull(message="Phone number of beneficiary is required")
	private String ben1PhoneNo;
	@Column
	private String ben2PhoneNo;
	@Column
	private String ben3PhoneNo;
	@Column
	private double ben1Allocation;
	@Column
	private double ben2Allocation;
	@Column
	private double ben3Allocation;

	@Column
	@NotNull
	private String nextOfKinSurname;

	@Column
	@NotNull
	private String nextOfKinFirstname;

	@Column
	@NotNull
	private String nextOfKinCountry;

	@Column
	@NotNull

	private String nextOfKinState;

	@Column

	private String nextOfKinEmail;

	@Column
	@NotNull
	private String nextOfKinPhoneNumber;

	@Column
	private String itfSurname;

	@Column
	private String itfFirstname;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date itfDob;

	@Column
	private String itfPhotoID;

	@Column
	private String itfIdNumber;

	@Column
	private String lastName2;

	@Column
	private String firstName2;

	@Column
	private String middleName2;

	@Column
	private String email2;

	@Column
	private String confirmEmail2;

	@Column
	private String phoneNumber2;

	@Column
	private String accountType2;

	@Column
	@TitleCheck
	private String title2;

	@Column
	@GenderCheck
	private String gender2;


	@Column
	private String otherNames2;

	@Column
	private String residentialPhone2;


	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob2;

	@Column
	private String country2;

	@Column
	private String state2;

	@Column
	private String nationality2;

	@Column
	private String countryOfResidence2;

	@Column

	private String occupation2;

	@Column
	private String employerName2;

	@Column
	private String levelOfEducation2;

	@Column
	@PhotoIDCheck
	private String photoId2;

	@Column
	private String idNumber2;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date idExpiryDate2;

	@Column
	private String mothersMaidenName2;

	@Column
	private String annualIncome2;

	@Column
	private String otherIncomeSources2;

	@Column
	private String passportFile;

	@Column
	private String sigFile;

	@Column
	private String validIDFile;

	@Column
	private String applicationRef;


	@Transient
	private boolean tcChecked=false;  //terms and conditions checked??

	@Transient
	private String signature;


	@Column
	private String userName;


	@Column
	private String password;

	@Transient
	private String confirmPassword;


	@Column
	private int salt;


	@Column
	private String secretQuestion;

	@Column
	private String secretAnswer;

	@Column
	private boolean formCompleted;

	@Column
	private String docRef;


	@Column
	private String accountNumber;

	@Column
	@NotNull
	@MaritalStatusCheck
	private String maritalStatus1;

	@Column
	@MaritalStatusCheck
	private String maritalStatus2;

	@Column
	@NotNull
	private String postalAddress1;

	@Column
	private String postalAddress2;

	@Column
	private String city1;

	@Column
	private String city2;

	@Column
	private String confirmationToken;

	@Column
	private boolean emailVerified;


	@Column
	private String riskProfile;

	@OneToMany(targetEntity = UserDocument.class,cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name="appbean")

	private Set<UserDocument> userDocuments = new HashSet<UserDocument>();

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public AppBeanVitals appBeanVitals;



	@Transient
	private String fullName1;  //to be used for signature on t&C page

	@Transient
	private String fullName2;   //to be used for signature on t&C page for joint applicant2

	public MultipartFile getPassportImage() {
		return passportImage;
	}

	public void setPassportImage(MultipartFile passportImage) {
		this.passportImage = passportImage;
	}

	public MultipartFile getSignatureImage() {
		return signatureImage;
	}

	public void setSignatureImage(MultipartFile signatureImage) {
		this.signatureImage = signatureImage;
	}

	public MultipartFile getPhotoIDImage() {
		return photoIDImage;
	}

	public void setPhotoIDImage(MultipartFile photoIDImage) {
		this.photoIDImage = photoIDImage;
	}

	public MultipartFile getProofOfAddressImage() {
		return proofOfAddressImage;
	}

	public void setProofOfAddressImage(MultipartFile proofOfAddressImage) {
		this.proofOfAddressImage = proofOfAddressImage;
	}

	public String getRiskProfile() {
		return riskProfile;
	}

	public void setRiskProfile(String riskProfile) {
		this.riskProfile = riskProfile;
	}

	public Set<UserDocument> getUserDocuments() {
		return userDocuments;
	}

	public void setUserDocuments(Set<UserDocument> userDocuments) {
		this.userDocuments = userDocuments;
	}

	public Date getDateFormCompleted() {
		return dateFormCompleted;
	}

	public void setDateFormCompleted(Date dateFormCompleted) {
		this.dateFormCompleted = dateFormCompleted;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public String getPostalAddress1() {
		return postalAddress1;
	}

	public void setPostalAddress1(String postalAddress1) {
		this.postalAddress1 = postalAddress1;
	}

	public String getPostalAddress2() {
		return postalAddress2;
	}

	public void setPostalAddress2(String postalAddress2) {
		this.postalAddress2 = postalAddress2;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getMaritalStatus1() {
		return maritalStatus1;
	}

	public void setMaritalStatus1(String maritalStatus1) {
		this.maritalStatus1 = maritalStatus1;
	}

	public String getMaritalStatus2() {
		return maritalStatus2;
	}

	public void setMaritalStatus2(String maritalStatus2) {
		this.maritalStatus2 = maritalStatus2;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isOnlineServiceApplicant() {
		return onlineServiceApplicant;
	}

	public void setOnlineServiceApplicant(boolean onlineServiceApplicant) {
		this.onlineServiceApplicant = onlineServiceApplicant;
	}

	public String getDocRef() {
		return docRef;
	}

	public void setDocRef(String docRef) {
		this.docRef = docRef;
	}

	public boolean isFormCompleted() {
		return formCompleted;
	}

	public void setFormCompleted(boolean formCompleted) {
		this.formCompleted = formCompleted;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public boolean isTcChecked() {
		return tcChecked;
	}

	public void setTcChecked(boolean tcChecked) {
		this.tcChecked = tcChecked;
	}

	public String getValidIDFile() {
		return validIDFile;
	}

	public void setValidIDFile(String validIDFile) {
		this.validIDFile = validIDFile;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getFirstName2() {
		return firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	public String getMiddleName2() {
		return middleName2;
	}

	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getConfirmEmail2() {
		return confirmEmail2;
	}

	public void setConfirmEmail2(String confirmEmail2) {
		this.confirmEmail2 = confirmEmail2;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getAccountType2() {
		return accountType2;
	}

	public void setAccountType2(String accountType2) {
		this.accountType2 = accountType2;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getGender2() {
		return gender2;
	}

	public void setGender2(String gender2) {
		this.gender2 = gender2;
	}

	public String getOtherNames2() {
		return otherNames2;
	}

	public void setOtherNames2(String otherNames2) {
		this.otherNames2 = otherNames2;
	}

	public String getResidentialPhone2() {
		return residentialPhone2;
	}

	public void setResidentialPhone2(String residentialPhone2) {
		this.residentialPhone2 = residentialPhone2;
	}

	public Date getDob2() {
		return dob2;
	}

	public void setDob2(Date dob2) {
		this.dob2 = dob2;
	}

	public String getCountry2() {
		return country2;
	}

	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	public String getState2() {
		return state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public String getItfSurname() {
		return itfSurname;
	}

	public void setItfSurname(String itfSurname) {
		this.itfSurname = itfSurname;
	}

	public String getItfFirstname() {
		return itfFirstname;
	}

	public void setItfFirstname(String itfFirstname) {
		this.itfFirstname = itfFirstname;
	}

	public Date getItfDob() {
		return itfDob;
	}

	public void setItfDob(Date itfDob) {
		this.itfDob = itfDob;
	}

	public String getItfPhotoID() {
		return itfPhotoID;
	}

	public void setItfPhotoID(String itfPhotoID) {
		this.itfPhotoID = itfPhotoID;
	}

	public String getItfIdNumber() {
		return itfIdNumber;
	}

	public void setItfIdNumber(String itfIdNumber) {
		this.itfIdNumber = itfIdNumber;
	}

	public String getNextOfKinSurname() {
		return nextOfKinSurname;
	}

	public void setNextOfKinSurname(String nextOfKinSurname) {
		this.nextOfKinSurname = nextOfKinSurname;
	}

	public String getNextOfKinFirstname() {
		return nextOfKinFirstname;
	}

	public void setNextOfKinFirstname(String nextOfKinFirstname) {
		this.nextOfKinFirstname = nextOfKinFirstname;
	}

	public String getNextOfKinCountry() {
		return nextOfKinCountry;
	}

	public void setNextOfKinCountry(String nextOfKinCountry) {
		this.nextOfKinCountry = nextOfKinCountry;
	}

	public String getNextOfKinState() {
		return nextOfKinState;
	}

	public void setNextOfKinState(String nextOfKinState) {
		this.nextOfKinState = nextOfKinState;
	}

	public String getNextOfKinEmail() {
		return nextOfKinEmail;
	}

	public void setNextOfKinEmail(String nextOfKinEmail) {
		this.nextOfKinEmail = nextOfKinEmail;
	}

	public String getNextOfKinPhoneNumber() {
		return nextOfKinPhoneNumber;
	}

	public void setNextOfKinPhoneNumber(String nextOfKinPhoneNumber) {
		this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getLevelOfEducation() {
		return levelOfEducation;
	}

	public void setLevelOfEducation(String levelOfEducation) {
		this.levelOfEducation = levelOfEducation;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public String getMothersMaidenName() {
		return mothersMaidenName;
	}

	public void setMothersMaidenName(String mothersMaidenName) {
		this.mothersMaidenName = mothersMaidenName;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getOtherIncomeSources() {
		return otherIncomeSources;
	}

	public void setOtherIncomeSources(String otherIncomeSources) {
		this.otherIncomeSources = otherIncomeSources;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getResidentialPhone() {
		return residentialPhone;
	}

	public void setResidentialPhone(String residentialPhone) {
		this.residentialPhone = residentialPhone;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getQ5() {
		return q5;
	}

	public void setQ5(String q5) {
		this.q5 = q5;
	}

	public String getBen1Surname() {
		return ben1Surname;
	}

	public void setBen1Surname(String ben1Surname) {
		this.ben1Surname = ben1Surname;
	}

	public String getBen2Surname() {
		return ben2Surname;
	}

	public void setBen2Surname(String ben2Surname) {
		this.ben2Surname = ben2Surname;
	}

	public String getBen3Surname() {
		return ben3Surname;
	}

	public void setBen3Surname(String ben3Surname) {
		this.ben3Surname = ben3Surname;
	}

	public String getBen1Firstname() {
		return ben1Firstname;
	}

	public void setBen1Firstname(String ben1Firstname) {
		this.ben1Firstname = ben1Firstname;
	}

	public String getBen2Firstname() {
		return ben2Firstname;
	}

	public void setBen2Firstname(String ben2Firstname) {
		this.ben2Firstname = ben2Firstname;
	}

	public String getBen3Firstname() {
		return ben3Firstname;
	}

	public void setBen3Firstname(String ben3Firstname) {
		this.ben3Firstname = ben3Firstname;
	}

	public String getBen1PhoneNo() {
		return ben1PhoneNo;
	}

	public void setBen1PhoneNo(String ben1PhoneNo) {
		this.ben1PhoneNo = ben1PhoneNo;
	}

	public String getBen2PhoneNo() {
		return ben2PhoneNo;
	}

	public void setBen2PhoneNo(String ben2PhoneNo) {
		this.ben2PhoneNo = ben2PhoneNo;
	}

	public String getBen3PhoneNo() {
		return ben3PhoneNo;
	}

	public void setBen3PhoneNo(String ben3PhoneNo) {
		this.ben3PhoneNo = ben3PhoneNo;
	}

	public double getBen1Allocation() {
		return ben1Allocation;
	}

	public void setBen1Allocation(double ben1Allocation) {
		this.ben1Allocation = ben1Allocation;
	}

	public double getBen2Allocation() {
		return ben2Allocation;
	}

	public void setBen2Allocation(double ben2Allocation) {
		this.ben2Allocation = ben2Allocation;
	}

	public double getBen3Allocation() {
		return ben3Allocation;
	}

	public void setBen3Allocation(double ben3Allocation) {
		this.ben3Allocation = ben3Allocation;
	}

	public String getNationality2() {
		return nationality2;
	}

	public void setNationality2(String nationality2) {
		this.nationality2 = nationality2;
	}

	public String getCountryOfResidence2() {
		return countryOfResidence2;
	}

	public void setCountryOfResidence2(String countryOfResidence2) {
		this.countryOfResidence2 = countryOfResidence2;
	}

	public String getOccupation2() {
		return occupation2;
	}

	public void setOccupation2(String occupation2) {
		this.occupation2 = occupation2;
	}

	public String getEmployerName2() {
		return employerName2;
	}

	public void setEmployerName2(String employerName2) {
		this.employerName2 = employerName2;
	}

	public String getLevelOfEducation2() {
		return levelOfEducation2;
	}

	public void setLevelOfEducation2(String levelOfEducation2) {
		this.levelOfEducation2 = levelOfEducation2;
	}

	public String getPhotoId2() {
		return photoId2;
	}

	public void setPhotoId2(String photoId2) {
		this.photoId2 = photoId2;
	}

	public String getIdNumber2() {
		return idNumber2;
	}

	public void setIdNumber2(String idNumber2) {
		this.idNumber2 = idNumber2;
	}

	public Date getIdExpiryDate2() {
		return idExpiryDate2;
	}

	public void setIdExpiryDate2(Date idExpiryDate2) {
		this.idExpiryDate2 = idExpiryDate2;
	}

	public String getMothersMaidenName2() {
		return mothersMaidenName2;
	}

	public void setMothersMaidenName2(String mothersMaidenName2) {
		this.mothersMaidenName2 = mothersMaidenName2;
	}

	public String getAnnualIncome2() {
		return annualIncome2;
	}

	public void setAnnualIncome2(String annualIncome2) {
		this.annualIncome2 = annualIncome2;
	}

	public String getOtherIncomeSources2() {
		return otherIncomeSources2;
	}

	public void setOtherIncomeSources2(String otherIncomeSources2) {
		this.otherIncomeSources2 = otherIncomeSources2;
	}

	public String getPassportFile() {
		return passportFile;
	}

	public void setPassportFile(String passportFile) {
		this.passportFile = passportFile;
	}

	public String getSigFile() {
		return sigFile;
	}

	public void setSigFile(String sigFile) {
		this.sigFile = sigFile;
	}

	public String getApplicationRef() {
		return applicationRef;
	}

	public void setApplicationRef(String applicationRef) {
		this.applicationRef = applicationRef;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getFullName1() {
		return fullName1;
	}

	public void setFullName1(String fullName1) {
		this.fullName1 = fullName1;
	}

	public String getFullName2() {
		return fullName2;
	}

	public void setFullName2(String fullName2) {
		this.fullName2 = fullName2;
	}

	public AppBeanVitals getAppBeanVitals() {
		return appBeanVitals;
	}

	public void setAppBeanVitals(AppBeanVitals appBeanVitals) {
		this.appBeanVitals = appBeanVitals;
	}


}