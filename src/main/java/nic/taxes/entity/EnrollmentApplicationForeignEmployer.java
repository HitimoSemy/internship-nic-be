package nic.taxes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enrollment_application_foreign_employer")
public class EnrollmentApplicationForeignEmployer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employer_id")
	private Integer foreignEmployerId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "enrl_app_id", referencedColumnName = "enrl_app_id")
	private EnrollmentApplicationForm enrollmentApplicationForm;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "employer_address")
	private String employerAddress;

	@Column(name = "monthly_pay")
	private Integer monthlyPay;
}
