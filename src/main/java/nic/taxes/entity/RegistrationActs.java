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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration_acts")
public class RegistrationActs implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "regt_act_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regtActId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "regt_id", referencedColumnName = "regt_id")
	private Registration registration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "act_code", referencedColumnName = "act_cd")
	private Acts acts;

	@Column(name = "cert_regt_no")
	private Integer certificateRegistrationNumber;

	@Column(name = "log_date")
	private LocalDate logDate;

	public RegistrationActs(Acts acts, Integer certificateRegistrationNumber, LocalDate logDate) {
		super();

		this.acts = acts;
		this.certificateRegistrationNumber = certificateRegistrationNumber;
		this.logDate = logDate;
	}

}
