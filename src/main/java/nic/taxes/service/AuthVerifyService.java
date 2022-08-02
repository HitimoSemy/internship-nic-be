package nic.taxes.service;

import org.springframework.http.ResponseEntity;

import nic.taxes.model.LoginRequests;
import nic.taxes.model.OfficerCreateRequest;
import nic.taxes.model.SignUpRequest;
import nic.taxes.model.UserVerificationRequest;

public interface AuthVerifyService {

	ResponseEntity<?> newUserVerification(UserVerificationRequest userVerificationRequest);

	ResponseEntity<?> verifyOtp(UserVerificationRequest userVerificationRequest);

	ResponseEntity<?> citizenSignUp(SignUpRequest signUpRequest);

	ResponseEntity<?> citizenLogin(LoginRequests loginRequests);

	ResponseEntity<?> officerCreate(OfficerCreateRequest officerCreateRequest);

	ResponseEntity<?> officerLogin(LoginRequests loginRequests);

	ResponseEntity<?> logoutUser();
}
