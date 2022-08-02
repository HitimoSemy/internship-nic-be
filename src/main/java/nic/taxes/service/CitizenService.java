package nic.taxes.service;

import org.springframework.http.ResponseEntity;

import nic.taxes.model.CitizenHomePayload;
import nic.taxes.model.EnrollmentApplicationFormModel;
import nic.taxes.model.EnrolmentView;
import nic.taxes.model.RegistrationApplicationFormModel;
import nic.taxes.model.RegistrationView;
import nic.taxes.model.RegtCancelApp;

public interface CitizenService {
	ResponseEntity<?> newRegistration(RegistrationApplicationFormModel registrationApplicationFormModel);

	ResponseEntity<?> newEnrollment(EnrollmentApplicationFormModel enrollmentApplicationFormModel);

	CitizenHomePayload getPayload(String id);

	RegistrationView getRegistration(String id);

	EnrolmentView getEnrolment(String id);

	ResponseEntity<?> regtCancellation(RegtCancelApp regtCancelApp);
}
