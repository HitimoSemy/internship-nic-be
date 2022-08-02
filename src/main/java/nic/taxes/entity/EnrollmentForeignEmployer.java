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
@Table(name = "enrollment_foreign_employer")
public class EnrollmentForeignEmployer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employer_id")
	private Integer foreignEmployerId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "enrl_id", referencedColumnName = "enrl_id")
	private Enrollment enrollment;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "employer_address")
	private String employerAddress;

	@Column(name = "monthly_pay")
	private Integer monthlyPay;

	public EnrollmentForeignEmployer(String employerName, String employerAddress, Integer monthlyPay) {
		super();
		this.employerName = employerName;
		this.employerAddress = employerAddress;
		this.monthlyPay = monthlyPay;
	}

}
