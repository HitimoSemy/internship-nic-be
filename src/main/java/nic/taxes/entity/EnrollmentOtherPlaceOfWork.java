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
@Table(name = "enrollment_workplaces")

public class EnrollmentOtherPlaceOfWork implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "work_place_id")
	private Integer workPlaceId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "enrl_id", referencedColumnName = "enrl_id")
	private Enrollment enrollment;

	@Column(name = "estd_name")
	private String estdName;

	@Column(name = "estd_address")
	private String estdAddress;

	public EnrollmentOtherPlaceOfWork(String estdName, String estdAddress) {
		super();
		this.estdName = estdName;
		this.estdAddress = estdAddress;
	}

}
