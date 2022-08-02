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
public class RegistrationView {

	private Integer regtId;

	private Integer officer;

	private LocalDate approvalDate;

	private String address;

	private String applicantName;

	private String estdName;

	private String estdAddress;

	private String taxCircle;

	private String employerStatus;

	private String employerClass;

	private List<RegistrationExtraEstdListView> registrationExtraEstablishments;

	private List<RegistrationActsListView> registrationActsListViews;

	private List<RegistrationEmployeeListView> registrationEmployeeListViews;
}
