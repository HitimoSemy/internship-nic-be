package nic.taxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEmployeeListView {

	private String employeeName;

	private Integer employeeStatus;

	private Integer employeeGrossPay;

	private Integer employeeTaxPayable;
}
