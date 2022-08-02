package nic.taxes.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nic.taxes.entity.Citizen;
import nic.taxes.entity.District;
import nic.taxes.entity.EmployeeTypes;
import nic.taxes.entity.EnrollmentApplicationActs;
import nic.taxes.entity.EnrollmentApplicationForeignEmployer;
import nic.taxes.entity.EnrollmentApplicationOtherPlaceOfWork;
import nic.taxes.entity.TaxCircle;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentApplicationFormModel {

	private Citizen citizen;

	private String applicantName;

	private LocalDate appDate;

	private String estdName;

	private String estdAddress;

	private District district;

	private Integer pincode;

	private TaxCircle taxCircle;

	private String estdDescr;

	private EmployeeTypes employeeTypes;

	private LocalDate dateOfCommence;

	private Integer grossAnnual;

	private List<EnrollmentApplicationForeignEmployer> enrollmentApplicationForeignEmployers;

	private String placeOfWork;

	private List<EnrollmentApplicationOtherPlaceOfWork> enrollmentApplicationOtherPLaceOfWorks;

	private Integer branchCertNos;

	private List<EnrollmentApplicationActs> enrollmentApplicationActs;
}
