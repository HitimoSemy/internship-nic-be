package nic.taxes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nic.taxes.model.LoginRequests;
import nic.taxes.model.OfficerCreateRequest;
import nic.taxes.model.SignUpRequest;
import nic.taxes.model.UserVerificationRequest;
import nic.taxes.service.AuthVerifyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/authVerify/")
public class AuthVerifyController {

	@Autowired
	private AuthVerifyService authVerifyService;

	@PostMapping("/newUser")
	public ResponseEntity<?> newUserVerification(
			@Validated @RequestBody UserVerificationRequest userVerificationRequest) {
		return authVerifyService.newUserVerification(userVerificationRequest);
	}

	@PostMapping("/otp")
	public ResponseEntity<?> verifyOtp(@Validated @RequestBody UserVerificationRequest userVerificationRequest) {
		return authVerifyService.verifyOtp(userVerificationRequest);
	}

	@PostMapping("/citizenLogin")
	public ResponseEntity<?> citizenLogin(@RequestBody LoginRequests loginRequests) {
		return authVerifyService.citizenLogin(loginRequests);
	}

	@PostMapping("/citizenSignUp")
	public ResponseEntity<?> citizenSignUp(@RequestBody SignUpRequest signUpRequest) {
		return authVerifyService.citizenSignUp(signUpRequest);
	}

	@PostMapping("/officerLogin")
	public ResponseEntity<?> officerLogin(@RequestBody LoginRequests loginRequests) {
		return authVerifyService.officerLogin(loginRequests);
	}

	@PostMapping("/officerCreate")
	public ResponseEntity<?> officerCreate(@RequestBody OfficerCreateRequest officerCreateRequest) {
		return authVerifyService.officerCreate(officerCreateRequest);
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		return authVerifyService.logoutUser();
	}
}
