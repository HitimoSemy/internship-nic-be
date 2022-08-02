package nic.taxes.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment_application")
public class EnrollmentApplicationForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrl_app_id")
	private Integer appId;

	@Column(name = "enrl_app_date")
	private LocalDate appDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false)
	private Citizen citizen;

	@Column(name = "applicant_name")
	private String applicantName;

	@Column(name = "estd_name")
	private String estdName;

	@Column(name = "estd_address")
	private String estdAddress;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "district", referencedColumnName = "district_cd", nullable = false)
	private District district;

	@Column(name = "pincode")
	private Integer pincode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estd_circle", referencedColumnName = "circle_cd", nullable = false)
	private TaxCircle taxCircle;

	@Column(name = "estd_descr")
	private String estdDescr;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
	private EmployeeTypes employeeTypes;

	@Column(name = "date_of_commence")
	private LocalDate dateOfCommence;

	@Column(name = "gross_annual")
	private Integer grossAnnual;

	@OneToMany(mappedBy = "enrollmentApplicationForm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentApplicationForeignEmployer> enrollmentApplicationForeignEmployers;

	@Column(name = "place_of_work")
	private String placeOfWork;

	@Column(name = "status")
	private Boolean status;

	@OneToMany(mappedBy = "enrollmentApplicationForm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentApplicationOtherPlaceOfWork> enrollmentApplicationOtherPLaceOfWorks;

	@Column(name = "no_of_branch_cert")
	private Integer branchCertNos;

	@OneToMany(mappedBy = "enrollmentApplicationForm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentApplicationActs> enrollmentApplicationActs;
}
