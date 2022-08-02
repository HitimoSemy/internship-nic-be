package nic.taxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nic.taxes.model.ActsModel;
import nic.taxes.model.DistrictModel;
import nic.taxes.model.EmployeeTypesModel;
import nic.taxes.model.EmployerClassModel;
import nic.taxes.model.EmployerStatusModel;
import nic.taxes.model.TaxCircleModel;
import nic.taxes.service.MiscRequestService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/misc/")
public class MiscRequestController {

	@Autowired
	private MiscRequestService miscRequestService;

	@GetMapping("/district")
	private List<DistrictModel> getAllDistricts() {
		return miscRequestService.getAllDistricts();
	}

	@GetMapping("/employerClass")
	private List<EmployerClassModel> getAllDesignations() {
		return miscRequestService.getAllEmployerClass();
	}

	@GetMapping("/employerStatus")
	private List<EmployerStatusModel> getAllEmployerStatus() {
		return miscRequestService.getAllEmployerStatus();
	}

	@GetMapping("/taxCircle/{id}")
	private List<TaxCircleModel> getAllCircle(@PathVariable("id") String id) {
		return miscRequestService.getAllCircle(id);
	}

	@GetMapping("/acts")
	private List<ActsModel> getAllActs() {
		return miscRequestService.getAllActs();
	}

	@GetMapping("/employeeTypes")
	private List<EmployeeTypesModel> getEmployeeTypes() {
		return miscRequestService.getEmployeeTypes();
	}

}
