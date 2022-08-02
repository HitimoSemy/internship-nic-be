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
@Table(name = "regtistration_application_employee_list")
@NoArgsConstructor
public class RegistrationApplicationEmployeeList implements Serializable {

	public RegistrationApplicationEmployeeList(String employeeName2, EmployerStatus employeeStatus2,
			Integer employeeGrossPay2, Integer employeeGrossPay3) {
		this.employeeName = employeeName2;
		this.employeeStatus = employeeStatus2;
		this.employeeGrossPay = employeeGrossPay2;
		this.employeeStatus = employeeStatus2;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer employeeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "regt_app_id", referencedColumnName = "regt_app_id")
	private RegistrationApplicationForm registrationApplicationForm;

	@Column(name = "employee_name")
	private String employeeName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_designation", referencedColumnName = "status_cd")
	private EmployerStatus employeeStatus;

	@Column(name = "employee_gross_pay")
	private Integer employeeGrossPay;

	@Column(name = "employee_tax_payable")
	private Integer employeeTaxPayable;

}
