package nic.taxes.entity;

import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enrl_id")
	private Integer enrlId;

	@Column(name = "enrl_date")
	private LocalDate appDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false)
	private Citizen citizen;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "officer_id", referencedColumnName = "officer_id", nullable = false)
	private Officer officer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "enrl_app_id", referencedColumnName = "enrl_app_id", nullable = false)
	private EnrollmentApplicationForm enrollmentApplicationForm;

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

	@OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentForeignEmployer> enrollmentForeignEmployers;

	@Column(name = "place_of_work")
	private String placeOfWork;

	@Column(name = "status")
	private Boolean status;

	@OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentOtherPlaceOfWork> enrollmentOtherPlaceOfWorks;

	@Column(name = "no_of_branch_cert")
	private Integer branchCertNos;

	@OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnrollmentActs> enrollmentActs;

	public Enrollment(LocalDate appDate, Citizen citizen, String applicantName, String estdName, String estdAddress,
			District district, Integer pincode, TaxCircle taxCircle, String estdDescr, EmployeeTypes employeeTypes,
			LocalDate dateOfCommence, Integer grossAnnual, String placeOfWork, Boolean status, Integer branchCertNos) {
		super();
		this.appDate = appDate;
		this.citizen = citizen;
		this.applicantName = applicantName;
		this.estdName = estdName;
		this.estdAddress = estdAddress;
		this.district = district;
		this.pincode = pincode;
		this.taxCircle = taxCircle;
		this.estdDescr = estdDescr;
		this.employeeTypes = employeeTypes;
		this.dateOfCommence = dateOfCommence;
		this.grossAnnual = grossAnnual;
		this.placeOfWork = placeOfWork;
		this.status = status;
		this.branchCertNos = branchCertNos;
	}

}
