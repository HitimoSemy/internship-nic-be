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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registration_application_extra_establishment")
@NoArgsConstructor
public class RegistrationApplicationExtraEstablishment implements Serializable {

	public RegistrationApplicationExtraEstablishment(String estdName2, String estdAddress2) {
		this.estdName = estdName2;
		this.estdAddress = estdAddress2;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "extra_estd_id")
	private Integer extraEstdId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "regt_app_id", referencedColumnName = "regt_app_id")
	private RegistrationApplicationForm registrationApplicationForm;

	@Column(name = "estd_name")
	private String estdName;

	@Column(name = "estd_address")
	private String estdAddress;
}
