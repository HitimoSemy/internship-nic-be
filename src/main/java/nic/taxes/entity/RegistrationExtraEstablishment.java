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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration_extra_estd_list")
public class RegistrationExtraEstablishment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "extra_estd_id")
	private Integer extraEstdId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "regt_id", referencedColumnName = "regt_id")
	private Registration registration;

	@Column(name = "estd_name")
	private String estdName;

	@Column(name = "estd_address")
	private String estdAddress;

	public RegistrationExtraEstablishment(String estdName, String estdAddress) {
		super();
		this.estdName = estdName;
		this.estdAddress = estdAddress;
	}

}
