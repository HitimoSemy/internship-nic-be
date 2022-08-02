package nic.taxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitizenHomePayload {

	boolean regtApp;
	boolean regt;
	boolean enrlApp;
	boolean enrl;
}
