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
@Table(name = "registration_employee_list")
public class RegistrationEmployees implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer employeeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "regt_id", referencedColumnName = "regt_id")
	private Registration registration;

	@Column(name = "employee_name")
	private String employeeName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_designation", referencedColumnName = "status_cd")
	private EmployerStatus employeeStatus;

	@Column(name = "employee_gross_pay")
	private Integer employeeGrossPay;

	@Column(name = "employee_tax_payable")
	private Integer employeeTaxPayable;

	public RegistrationEmployees(String employeeName, EmployerStatus employeeStatus, Integer employeeGrossPay,
			Integer employeeTaxPayable) {
		super();
		this.employeeName = employeeName;
		this.employeeStatus = employeeStatus;
		this.employeeGrossPay = employeeGrossPay;
		this.employeeTaxPayable = employeeTaxPayable;
	}

}
