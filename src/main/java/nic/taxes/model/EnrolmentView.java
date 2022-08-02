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
public class EnrolmentView {

	private Integer enrlId;

	private LocalDate approvalDate;

	private Integer officer;

	private String applicantName;

	private String estdName;

	private String estdAddress;

	private String taxCircle;

	private String employeeTypes;

	private List<EnrollmentForeignEmployerView> enrollmentForeignEmployers;

	private List<EnrollmentOtherPlaceOfWorkView> enrollmentOtherPlaceOfWorks;

	private List<EnrollmentActsView> enrollmentActs;
}
