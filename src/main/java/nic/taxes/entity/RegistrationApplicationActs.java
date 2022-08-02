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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "registration_application_acts")
public class RegistrationApplicationActs implements Serializable {

	public RegistrationApplicationActs(Integer certificateRegistrationNumber2, Acts acts2) {
		this.acts = acts2;
		this.certificateRegistrationNumber = certificateRegistrationNumber2;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "regt_app_act_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regAppId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "regt_app_id", referencedColumnName = "regt_app_id")
	private RegistrationApplicationForm registrationApplicationForm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "act_code", referencedColumnName = "act_cd")
	private Acts acts;

	@Column(name = "cert_regt_no")
	private Integer certificateRegistrationNumber;

	@Column(name = "log_date")
	private LocalDate logDate;

}
