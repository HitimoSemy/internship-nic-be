package nic.taxes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import nic.taxes.model.ApproveEnrlNoEdit;
import nic.taxes.model.ApproveRegtNoEdit;
import nic.taxes.model.EnrollmentApplicationFormView;
import nic.taxes.model.ListOfNewEnrollments;
import nic.taxes.model.ListOfNewRegistrations;
import nic.taxes.model.RegistrationApplicationFormView;

public interface OfficerService {

	List<ListOfNewRegistrations> getAllRegistrationApplicationForms(String id);

	RegistrationApplicationFormView viewRegistrationForm(String id);

	List<ListOfNewEnrollments> getAllEnrollmentApplicationForms(String id);

	EnrollmentApplicationFormView viewEnrollment(String id);

	ResponseEntity<?> approveRegtNoEdit(ApproveRegtNoEdit approveRegtNoEdit);

	ResponseEntity<?> approveEnrlNoEdit(ApproveEnrlNoEdit approveEnrlNoEdit);

}