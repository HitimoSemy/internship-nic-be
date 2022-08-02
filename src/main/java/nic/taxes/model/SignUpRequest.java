package nic.taxes.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

	private String loginName;

	private String mobileNumber;

	private String password;
}
