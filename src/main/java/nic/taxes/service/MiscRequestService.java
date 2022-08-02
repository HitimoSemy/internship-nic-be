package nic.taxes.service;

import java.util.List;

import nic.taxes.model.ActsModel;
import nic.taxes.model.DistrictModel;
import nic.taxes.model.EmployeeTypesModel;
import nic.taxes.model.EmployerClassModel;
import nic.taxes.model.EmployerStatusModel;
import nic.taxes.model.TaxCircleModel;

public interface MiscRequestService {

	List<DistrictModel> getAllDistricts();

	List<EmployerClassModel> getAllEmployerClass();

	List<EmployerStatusModel> getAllEmployerStatus();

	List<TaxCircleModel> getAllCircle(String id);

	List<ActsModel> getAllActs();

	List<EmployeeTypesModel> getEmployeeTypes();

}
