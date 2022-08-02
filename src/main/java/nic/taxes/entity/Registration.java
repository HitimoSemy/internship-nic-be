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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class Registration implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "regt_id")
	private Integer regtId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false)
	private Citizen citizen;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "officer_id", referencedColumnName = "officer_id", nullable = false)
	private Officer officer;

	@Column(name = "approval_date")
	private LocalDate approvalDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "regt_app_id", referencedColumnName = "regt_app_id", nullable = false)
	private RegistrationApplicationForm registrationApplicationForm;

	@Column(name = "regt_app_date")
	private LocalDate appDate;

	@Column(name = "applicant_name")
	private String applicantName;

	@Column(name = "address")
	private String address;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "district", referencedColumnName = "district_cd", nullable = false)
	private District district;

	@Column(name = "pincode")
	private Integer pincode;

	@Column(name = "estd_name")
	private String estdName;

	@Column(name = "estd_address")
	private String estdAddress;

	@Column(name = "estd_descr")
	private String estdDescr;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estd_circle", referencedColumnName = "circle_cd", nullable = false)
	private TaxCircle taxCircle;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_status", referencedColumnName = "status_cd", nullable = false)
	private EmployerStatus employerStatus;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_class", referencedColumnName = "class_cd", nullable = false)
	private EmployerClass employerClass;

	@Column(name = "status")
	private Boolean status;

	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private List<RegistrationEmployees> registrationEmployees;

	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private List<RegistrationActs> registrationActs;

	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private List<RegistrationExtraEstablishment> registrationExtraEstablishments;

	public Registration(Citizen citizen, LocalDate appDate, String applicantName, String address, District district,
			Integer pincode, String estdName, String estdAddress, String estdDescr, TaxCircle taxCircle,
			EmployerStatus employerStatus, EmployerClass employerClass) {
		super();
		this.citizen = citizen;
		this.appDate = appDate;
		this.applicantName = applicantName;
		this.address = address;
		this.district = district;
		this.pincode = pincode;
		this.estdName = estdName;
		this.estdAddress = estdAddress;
		this.estdDescr = estdDescr;
		this.taxCircle = taxCircle;
		this.employerStatus = employerStatus;
		this.employerClass = employerClass;
	}

}
