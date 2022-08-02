package nic.taxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nic.taxes.model.ApproveEnrlNoEdit;
import nic.taxes.model.ApproveRegtNoEdit;
import nic.taxes.model.EnrollmentApplicationFormView;
import nic.taxes.model.ListOfNewEnrollments;
import nic.taxes.model.ListOfNewRegistrations;
import nic.taxes.model.RegistrationApplicationFormView;
import nic.taxes.service.OfficerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/officer/")
public class OfficerSercviceController {

	@Autowired
	private OfficerService officerService;

	@GetMapping("/registrations/{id}")
	public List<ListOfNewRegistrations> registrations(@PathVariable("id") String id) {

		return officerService.getAllRegistrationApplicationForms(id);
	}

	@GetMapping("/viewRegistration/{id}")
	public RegistrationApplicationFormView viewRegistration(@PathVariable("id") String id) {
		return officerService.viewRegistrationForm(id);
	}

	@GetMapping("enrollments/{id}")
	public List<ListOfNewEnrollments> enrollments(@PathVariable("id") String id) {
		return officerService.getAllEnrollmentApplicationForms(id);
	}

	@GetMapping("/viewEnrollment/{id}")
	public EnrollmentApplicationFormView viewEnrollment(@PathVariable("id") String id) {
		return officerService.viewEnrollment(id);
	}

	@PostMapping("/approveRegtNoEdit")
	public ResponseEntity<?> approveRegistration(@RequestBody ApproveRegtNoEdit approveRegtNoEdit) {
		return officerService.approveRegtNoEdit(approveRegtNoEdit);
	}

	@PostMapping("/approveEnrlNoEdit")
	public ResponseEntity<?> approveEnrollment(@RequestBody ApproveEnrlNoEdit approveEnrlNoEdit) {
		return officerService.approveEnrlNoEdit(approveEnrlNoEdit);
	}
}
