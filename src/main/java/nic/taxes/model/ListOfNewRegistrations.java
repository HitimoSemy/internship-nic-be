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
public class ListOfNewRegistrations {

	private Integer appId;

	private String applicantName;

	private LocalDate appDate;
}
