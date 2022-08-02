package nic.taxes.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nic.taxes.entity.Citizen;
import nic.taxes.entity.District;
import nic.taxes.entity.EmployerClass;
import nic.taxes.entity.EmployerStatus;
import nic.taxes.entity.RegistrationApplicationActs;
import nic.taxes.entity.RegistrationApplicationEmployeeList;
import nic.taxes.entity.RegistrationApplicationExtraEstablishment;
import nic.taxes.entity.TaxCircle;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationApplicationFormModel {

	private Citizen citizen;

	private String applicantName;

	private String address;

	private Integer pincode;

	private EmployerStatus employerStatus;

	private String estdName;

	private String estdAddress;

	private District district;

	private TaxCircle taxCircle;

	private EmployerClass employerClass;

	private String estdDescr;

	private List<RegistrationApplicationEmployeeList> registrationEmployeeLists;;

	private List<RegistrationApplicationActs> registrationApplicationActs;

	private List<RegistrationApplicationExtraEstablishment> registrationApplicationExtraEstablishments;
}
