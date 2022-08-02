package nic.taxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nic.taxes.entity.Citizen;
import nic.taxes.entity.Registration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegtCancelApp {

	private Citizen citizen;

	private Registration registration;
}
