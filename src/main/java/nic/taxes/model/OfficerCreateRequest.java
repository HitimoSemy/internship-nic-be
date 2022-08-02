package nic.taxes.model;

import lombok.Getter;
import lombok.Setter;
import nic.taxes.entity.TaxCircle;

@Getter
@Setter
public class OfficerCreateRequest {

	private String loginName;

	private String mobileNumber;

	private String password;

	private TaxCircle circle;
}
