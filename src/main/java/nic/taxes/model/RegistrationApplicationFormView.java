package nic.taxes.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationApplicationFormView {

	private String applicantName;

	private String address;

	private Integer pincode;

	private Integer registrationApplicationForm;

	private String employerStatus;

	private LocalDate appDate;

	private String estdName;

	private String estdAddress;

	private String district;

	private String taxCircle;

	private String employerClass;

	private String estdDescr;

	private List<RegistrationEmployeeListView> registrationEmployeeLists;;

	private List<RegistrationActsListView> registrationApplicationActs;

	private List<RegistrationExtraEstdListView> registrationApplicationExtraEstablishments;
}
