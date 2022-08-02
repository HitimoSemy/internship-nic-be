package nic.taxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentForeignEmployerView {

	private String employerName;

	private String employerAddress;

	private Integer monthlyPay;
}
