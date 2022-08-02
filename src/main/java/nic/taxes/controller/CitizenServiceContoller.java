package nic.taxes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nic.taxes.model.CitizenHomePayload;
import nic.taxes.model.EnrollmentApplicationFormModel;
import nic.taxes.model.EnrolmentView;
import nic.taxes.model.RegistrationApplicationFormModel;
import nic.taxes.model.RegistrationView;
import nic.taxes.model.RegtCancelApp;
import nic.taxes.service.CitizenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/citizen/")
public class CitizenServiceContoller {

	@Autowired
	private CitizenService citizenService;

	@PostMapping("/newRegistration")
	public ResponseEntity<?> newRegistration(
			@RequestBody RegistrationApplicationFormModel registrationApplicationFormModel) {

		return citizenService.newRegistration(registrationApplicationFormModel);
	}

	@PostMapping("/newEnrollment")
	public ResponseEntity<?> newEnrollment(@RequestBody EnrollmentApplicationFormModel enrollmentApplicationFormModel) {
		return citizenService.newEnrollment(enrollmentApplicationFormModel);
	}

	@GetMapping("/registrationCertificate/{id}")
	public RegistrationView getRegistration(@PathVariable("id") String id) {
		return citizenService.getRegistration(id);
	}

	@GetMapping("/enrolmentCertificate/{id}")
	public EnrolmentView getEnrolment(@PathVariable("id") String id) {
		return citizenService.getEnrolment(id);
	}

	@GetMapping("/homePayload/{id}")
	public CitizenHomePayload getPayload(@PathVariable("id") String id) {
		return citizenService.getPayload(id);
	}

	@PostMapping("/regtCancellation")
	public ResponseEntity<?> regtCancellationApp(@RequestBody RegtCancelApp regtCancelApp) {
		return citizenService.regtCancellation(regtCancelApp);
	}
}
