package nic.taxes.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationActsListView {

	private Integer acts;

	private Integer certificateRegistrationNumber;

	private LocalDate logDate;
}
