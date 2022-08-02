package nic.taxes.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nic.taxes.entity.Acts;
import nic.taxes.entity.District;
import nic.taxes.entity.EmployeeTypes;
import nic.taxes.entity.EmployerClass;
import nic.taxes.entity.EmployerStatus;
import nic.taxes.entity.TaxCircle;
import nic.taxes.model.ActsModel;
import nic.taxes.model.DistrictModel;
import nic.taxes.model.EmployeeTypesModel;
import nic.taxes.model.EmployerClassModel;
import nic.taxes.model.EmployerStatusModel;
import nic.taxes.model.TaxCircleModel;
import nic.taxes.repository.ActsRepository;
import nic.taxes.repository.DistrictRepository;
import nic.taxes.repository.EmployeeTypesRepository;
import nic.taxes.repository.EmployerClassRepository;
import nic.taxes.repository.EmployerStatusRepository;
import nic.taxes.repository.TaxCircleRepository;
import nic.taxes.service.MiscRequestService;

@Service
public class MiscRequestServiceImpl implements MiscRequestService {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private EmployerClassRepository employerClassRepository;

	@Autowired
	private EmployerStatusRepository employerStatusRepository;

	@Autowired
	private TaxCircleRepository taxCircleRepository;

	@Autowired
	private ActsRepository actsRepository;

	@Autowired
	private EmployeeTypesRepository employeeTypesRepository;

	@Override
	public List<DistrictModel> getAllDistricts() {
		List<District> districts = districtRepository.findAll();
		List<DistrictModel> districtModels = districts.stream()
				.map(distData -> new DistrictModel(distData.getDistId(), distData.getDistName()))
				.collect(Collectors.toList());
		return districtModels;
	}

	@Override
	public List<EmployerClassModel> getAllEmployerClass() {
		List<EmployerClass> employerClasses = employerClassRepository.findAll();
		List<EmployerClassModel> employerClassModels = employerClasses.stream()
				.map(classData -> new EmployerClassModel(classData.getClassId(), classData.getClassName()))
				.collect(Collectors.toList());
		return employerClassModels;
	}

	@Override
	public List<EmployerStatusModel> getAllEmployerStatus() {
		List<EmployerStatus> employerDesignations = employerStatusRepository.findAll();
		List<EmployerStatusModel> employerStatusModels = employerDesignations.stream()
				.map(designationData -> new EmployerStatusModel(designationData.getStatusId(),
						designationData.getStatusName()))
				.collect(Collectors.toList());
		return employerStatusModels;
	}

	@Override
	public List<TaxCircleModel> getAllCircle(String id) {
		List<TaxCircle> taxCircles = taxCircleRepository.findAllByDistrictDistId(Integer.parseInt(id));
		List<TaxCircleModel> taxCircleModels = taxCircles.stream()
				.map(circleData -> new TaxCircleModel(circleData.getCircleId(), circleData.getCircleName(),
						circleData.getDistrict()))
				.collect(Collectors.toList());
		return taxCircleModels;
	}

	@Override
	public List<ActsModel> getAllActs() {
		List<Acts> actsList = actsRepository.findAll();
		List<ActsModel> actsModels = actsList.stream()
				.map(actsData -> new ActsModel(actsData.getActCode(), actsData.getActName()))
				.collect(Collectors.toList());
		return actsModels;
	}

	@Override
	public List<EmployeeTypesModel> getEmployeeTypes() {
		List<EmployeeTypes> types = employeeTypesRepository.findAll();
		List<EmployeeTypesModel> models = types.stream()
				.map(typeData -> new EmployeeTypesModel(typeData.getTypeId(), typeData.getTypeName()))
				.collect(Collectors.toList());

		return models;
	}
}
