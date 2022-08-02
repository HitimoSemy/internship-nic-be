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
public class EnrollmentApplicationFormView {

	private LocalDate appDate;

	private Integer enrollmentApplicationForm;

	private String applicantName;

	private String estdName;

	private String estdAddress;

	private String district;

	private Integer pincode;

	private String taxCircle;

	private String estdDescr;

	private String employeeTypes;

	private LocalDate dateOfCommence;

	private Integer grossAnnual;

	private List<EnrollmentForeignEmployerView> enrollmentForeignEmployers;

	private String placeOfWork;

	private List<EnrollmentOtherPlaceOfWorkView> enrollmentOtherPlaceOfWorks;

	private Integer branchCertNos;

	private List<EnrollmentActsView> enrollmentActs;
}
