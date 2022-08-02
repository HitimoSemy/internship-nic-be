package nic.taxes.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentActsView {

	private Integer acts;

	private Integer certificateRegistrationNumber;

	private LocalDate logDate;
}
