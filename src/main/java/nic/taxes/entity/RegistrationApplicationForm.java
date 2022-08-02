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
@Table(name = "regtistration_application")
public class RegistrationApplicationForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "regt_app_id")
	private Integer appId;

	@Column(name = "regt_app_date")
	private LocalDate appDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false)
	private Citizen citizen;

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

	@Column(name = "status")
	private Boolean status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estd_circle", referencedColumnName = "circle_cd", nullable = false)
	private TaxCircle taxCircle;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_status", referencedColumnName = "status_cd", nullable = false)
	private EmployerStatus employerStatus;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_class", referencedColumnName = "class_cd", nullable = false)
	private EmployerClass employerClass;

	@OneToMany(mappedBy = "registrationApplicationForm", cascade = CascadeType.ALL)
	private List<RegistrationApplicationEmployeeList> registrationEmployeeLists;

	@OneToMany(mappedBy = "registrationApplicationForm", cascade = CascadeType.ALL)
	private List<RegistrationApplicationActs> registrationApplicationActs;

	@OneToMany(mappedBy = "registrationApplicationForm", cascade = CascadeType.ALL)
	private List<RegistrationApplicationExtraEstablishment> registrationApplicationExtraEstablishments;

}
