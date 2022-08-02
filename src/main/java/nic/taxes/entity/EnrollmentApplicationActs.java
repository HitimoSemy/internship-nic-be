package nic.taxes.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "enrollment_application_acts")
public class EnrollmentApplicationActs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enrl_app_act_id")
	private Integer enrlAppId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "enrl_app_id", referencedColumnName = "enrl_app_id")
	private EnrollmentApplicationForm enrollmentApplicationForm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "act_code", referencedColumnName = "act_cd")
	private Acts acts;

	@Column(name = "cert_regt_no")
	private Integer certificateRegistrationNumber;

	@Column(name = "log_date")
	private LocalDate logDate;
}
