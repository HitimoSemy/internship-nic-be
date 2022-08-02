package nic.taxes.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import nic.taxes.entity.Citizen;
import nic.taxes.entity.ERole;
import nic.taxes.entity.Officer;
import nic.taxes.entity.Role;
import nic.taxes.entity.TaxCircle;
import nic.taxes.entity.UserVerificationEntity;
import nic.taxes.generator.OtpGenerator;
import nic.taxes.model.CitizenInfoResponse;
import nic.taxes.model.LoginRequests;
import nic.taxes.model.MessageResponse;
import nic.taxes.model.OfficerCreateRequest;
import nic.taxes.model.OfficerInfoResponse;
import nic.taxes.model.SignUpRequest;
import nic.taxes.model.UserVerificationRequest;
import nic.taxes.repository.CitizenRepository;
import nic.taxes.repository.OfficerRepository;
import nic.taxes.repository.RoleRepository;
import nic.taxes.repository.UserVerificationRepository;
import nic.taxes.security.CitizenDetailsImpl;
import nic.taxes.security.JwtUtils;
import nic.taxes.security.OfficerDetailsImpl;
import nic.taxes.service.AuthVerifyService;

@Service
public class AuthVerifyServiceImpl implements AuthVerifyService {

	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private OfficerRepository officerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserVerificationRepository userVerificationRepository;

	@Autowired
	private OtpGenerator otpGenerator;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ResponseEntity<?> citizenSignUp(@RequestParam SignUpRequest signUpRequest) {

		if (citizenRepository.existsByLoginName(signUpRequest.getLoginName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		Role role = roleRepository.findByName(ERole.ROLE_CITIZEN);

		Citizen citizen = new Citizen(signUpRequest.getLoginName(), signUpRequest.getMobileNumber(),
				encoder.encode(signUpRequest.getPassword()), LocalDate.now());

		citizen.setRole(role);
		citizenRepository.save(citizen);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@Override
	public ResponseEntity<?> citizenLogin(@Validated @RequestBody LoginRequests loginRequests) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequests.getLoginName(), loginRequests.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		CitizenDetailsImpl citizenDetails = (CitizenDetailsImpl) authentication.getPrincipal();

		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(citizenDetails);

		Role role = citizenDetails.getRole();

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
				.body(new CitizenInfoResponse(citizenDetails.getId(), citizenDetails.getUsername(), role));
	}

	@Override
	public ResponseEntity<?> officerCreate(@RequestParam OfficerCreateRequest officerCreateRequest) {
		if (officerRepository.existsByLoginName(officerCreateRequest.getLoginName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		Role role = roleRepository.findByName(ERole.ROLE_OFFICER);

		Officer officer = new Officer(officerCreateRequest.getLoginName(), officerCreateRequest.getMobileNumber(),
				encoder.encode(officerCreateRequest.getPassword()), LocalDate.now(), officerCreateRequest.getCircle());

		officer.setRole(role);
		officerRepository.save(officer);
		return ResponseEntity.ok(new MessageResponse("Officer created successfully!"));
	}

	@Override
	public ResponseEntity<?> officerLogin(@Validated @RequestParam LoginRequests loginRequests) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequests.getLoginName(), loginRequests.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		OfficerDetailsImpl officerDetails = (OfficerDetailsImpl) authentication.getPrincipal();

		ResponseCookie jwtCookie = jwtUtils.generateJwtCookieOff(officerDetails);

		Role role = officerDetails.getRole();

		TaxCircle circle = officerDetails.getCircle();

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
				.body(new OfficerInfoResponse(officerDetails.getId(), officerDetails.getUsername(), role, circle));
	}

	@Override
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse("You've been signed out!"));
	}

	@Override
	public ResponseEntity<?> newUserVerification(UserVerificationRequest userVerificationRequest) {
		if (citizenRepository.existsByLoginName(userVerificationRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		if (userVerificationRepository.existsByEmail(userVerificationRequest.getEmail())) {
			userVerificationRepository.deleteById(userVerificationRequest.getEmail());
		}
		int otp = otpGenerator.generateOTP();

		UserVerificationEntity userVerificationEntity = new UserVerificationEntity();
		userVerificationEntity.setEmail(userVerificationRequest.getEmail());
		userVerificationEntity.setMobileNumber(userVerificationRequest.getMobileNumber());
		userVerificationEntity.setOtp(otp);

		// send one time password via email/phone
		System.out.println(otp);
		userVerificationRepository.save(userVerificationEntity);

		return ResponseEntity.ok().body(new MessageResponse("Email is valid, waiting for otp" + otp + "is your Otp"));
	}

	@Override
	public ResponseEntity<?> verifyOtp(UserVerificationRequest userVerificationRequest) {
		UserVerificationEntity userVerificationEntity = new UserVerificationEntity();
		userVerificationEntity = userVerificationRepository.findByEmail(userVerificationRequest.getEmail());
		if (userVerificationRequest.getOtp() == userVerificationEntity.getOtp()) {
			return ResponseEntity.ok().body(new MessageResponse("Otp verified"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid Otp"));
		}
	}

}
