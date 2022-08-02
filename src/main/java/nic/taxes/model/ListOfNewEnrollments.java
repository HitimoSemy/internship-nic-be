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

public class ListOfNewEnrollments {

	private Integer enrlId;

	private String applicantName;

	private LocalDate appDate;

}
