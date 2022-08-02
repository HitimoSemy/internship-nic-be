package nic.taxes.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nic.taxes.entity.Enrollment;
import nic.taxes.entity.EnrollmentActs;
import nic.taxes.entity.EnrollmentApplicationForm;
import nic.taxes.entity.EnrollmentForeignEmployer;
import nic.taxes.entity.EnrollmentOtherPlaceOfWork;
import nic.taxes.entity.Registration;
import nic.taxes.entity.RegistrationActs;
import nic.taxes.entity.RegistrationApplicationForm;
import nic.taxes.entity.RegistrationCancellationApplicaiton;
import nic.taxes.entity.RegistrationEmployees;
import nic.taxes.entity.RegistrationExtraEstablishment;
import nic.taxes.model.CitizenHomePayload;
import nic.taxes.model.EnrollmentActsView;
import nic.taxes.model.EnrollmentApplicationFormModel;
import nic.taxes.model.EnrollmentForeignEmployerView;
import nic.taxes.model.EnrollmentOtherPlaceOfWorkView;
import nic.taxes.model.EnrolmentView;
import nic.taxes.model.MessageResponse;
import nic.taxes.model.RegistrationActsListView;
import nic.taxes.model.RegistrationApplicationFormModel;
import nic.taxes.model.RegistrationEmployeeListView;
import nic.taxes.model.RegistrationExtraEstdListView;
import nic.taxes.model.RegistrationView;
import nic.taxes.model.RegtCancelApp;
import nic.taxes.repository.EnrollmentActsRepositiory;
import nic.taxes.repository.EnrollmentApplicationFormRepository;
import nic.taxes.repository.EnrollmentForeignEmployerRepository;
import nic.taxes.repository.EnrollmentOtherWorkplacesRepository;
import nic.taxes.repository.EnrollmentRepository;
import nic.taxes.repository.RegistrationActsRepository;
import nic.taxes.repository.RegistrationApplicationFormRepository;
import nic.taxes.repository.RegistrationEmployeesRepository;
import nic.taxes.repository.RegistrationExtraEstablishmentRepository;
import nic.taxes.repository.RegistrationRepository;
import nic.taxes.repository.RegtCancelAppRepository;
import nic.taxes.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private RegistrationApplicationFormRepository registrationApplicationFormRepository;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationExtraEstablishmentRepository registrationExtraEstablishmentRepository;

	@Autowired
	private EnrollmentApplicationFormRepository enrollmentApplicationFormRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private EnrollmentActsRepositiory enrollmentActsRepositiory;

	@Autowired
	private EnrollmentForeignEmployerRepository enrollmentForeignEmployerRepository;

	@Autowired
	private EnrollmentOtherWorkplacesRepository enrollmentOtherWorkplacesRepository;

	@Autowired
	private RegistrationActsRepository registrationActsRepository;

	@Autowired
	private RegtCancelAppRepository regtCancelAppRepository;

	@Autowired
	private RegistrationEmployeesRepository registrationEmployeesRepository;

	@Override
	public ResponseEntity<?> newRegistration(RegistrationApplicationFormModel registrationApplicationFormModel) {

		RegistrationApplicationForm registrationApplicationForm = new RegistrationApplicationForm();
		BeanUtils.copyProperties(registrationApplicationFormModel, registrationApplicationForm);

		registrationApplicationForm.getRegistrationApplicationActs().forEach((act) -> {
			act.setRegistrationApplicationForm(registrationApplicationForm);
		});

		registrationApplicationForm.getRegistrationApplicationExtraEstablishments().forEach((est) -> {
			est.setRegistrationApplicationForm(registrationApplicationForm);
		});

		registrationApplicationForm.getRegistrationEmployeeLists().forEach((emp) -> {
			emp.setRegistrationApplicationForm(registrationApplicationForm);
		});

		registrationApplicationForm.setStatus(false);
		registrationApplicationForm.setAppDate(LocalDate.now());
		registrationApplicationFormRepository.save(registrationApplicationForm);

		return ResponseEntity.ok(new MessageResponse("Application registered successfully!"));
	}

	@Override
	public ResponseEntity<?> newEnrollment(EnrollmentApplicationFormModel enrollmentApplicationFormModel) {
		EnrollmentApplicationForm enrollmentApplicationForm = new EnrollmentApplicationForm();
		BeanUtils.copyProperties(enrollmentApplicationFormModel, enrollmentApplicationForm);

		enrollmentApplicationFormModel.getEnrollmentApplicationActs().forEach((act) -> {
			act.setEnrollmentApplicationForm(enrollmentApplicationForm);
		});

		enrollmentApplicationFormModel.getEnrollmentApplicationForeignEmployers().forEach((fre) -> {
			fre.setEnrollmentApplicationForm(enrollmentApplicationForm);
		});

		enrollmentApplicationFormModel.getEnrollmentApplicationOtherPLaceOfWorks().forEach((other) -> {
			other.setEnrollmentApplicationForm(enrollmentApplicationForm);
		});

		enrollmentApplicationForm.setStatus(false);
		enrollmentApplicationForm.setAppDate(LocalDate.now());
		enrollmentApplicationFormRepository.save(enrollmentApplicationForm);
		return ResponseEntity.ok(new MessageResponse("Application enrolled successfully!"));
	}

	@Override
	public RegistrationView getRegistration(String id) {
		Registration regt = new Registration();
		regt = registrationRepository.findByRegtIdAndStatus(Integer.parseInt(id));

		List<RegistrationExtraEstablishment> ree = registrationExtraEstablishmentRepository
				.findAllByRegisrationRegtId(regt.getRegtId());

		List<RegistrationExtraEstdListView> reeView = ree.stream()
				.map(data -> new RegistrationExtraEstdListView(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		List<RegistrationActs> ra = registrationActsRepository.findAllByRegistraitonRegtId(regt.getRegtId());

		List<RegistrationActsListView> raView = ra.stream()
				.map(data -> new RegistrationActsListView(data.getActs().getActCode(),
						data.getCertificateRegistrationNumber(), data.getLogDate()))
				.collect(Collectors.toList());

		List<RegistrationEmployees> rel = registrationEmployeesRepository.findAllByRegistrationRegtId(regt.getRegtId());

		List<RegistrationEmployeeListView> relView = rel.stream()
				.map(data -> new RegistrationEmployeeListView(data.getEmployeeName(),
						data.getEmployeeStatus().getStatusId(), data.getEmployeeGrossPay(),
						data.getEmployeeTaxPayable()))
				.collect(Collectors.toList());

		RegistrationView view = new RegistrationView(regt.getRegtId(), regt.getOfficer().getOfficerId(),
				regt.getApprovalDate(), regt.getAddress(), regt.getApplicantName(), regt.getEstdName(),
				regt.getEstdAddress(), regt.getTaxCircle().getCircleName(), regt.getEmployerStatus().getStatusName(),
				regt.getEmployerClass().getClassName(), reeView, raView, relView);

		return view;

	}

	@Override
	public EnrolmentView getEnrolment(String id) {
		Enrollment enrl = new Enrollment();
		enrl = enrollmentRepository.findByEnrlIdAndStatus(Integer.parseInt(id));

		List<EnrollmentForeignEmployer> efe = enrollmentForeignEmployerRepository
				.findAllByEnrollmentEnrlId(enrl.getEnrlId());

		List<EnrollmentForeignEmployerView> efeView = efe.stream()
				.map(data -> new EnrollmentForeignEmployerView(data.getEmployerName(), data.getEmployerAddress(),
						data.getMonthlyPay()))
				.collect(Collectors.toList());

		List<EnrollmentOtherPlaceOfWork> opow = enrollmentOtherWorkplacesRepository
				.findAllByEnrollmentEnrlId(enrl.getEnrlId());

		List<EnrollmentOtherPlaceOfWorkView> opowView = opow.stream()
				.map(data -> new EnrollmentOtherPlaceOfWorkView(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		List<EnrollmentActs> ea = enrollmentActsRepositiory.findAllByEnrollmentEnrlId(enrl.getEnrlId());

		List<EnrollmentActsView> eaView = ea.stream()
				.map(data -> new EnrollmentActsView(data.getCertificateRegistrationNumber(),
						data.getActs().getActCode(), data.getLogDate()))
				.collect(Collectors.toList());

		EnrolmentView enrlView = new EnrolmentView(enrl.getEnrlId(), enrl.getAppDate(),
				enrl.getOfficer().getOfficerId(), enrl.getApplicantName(), enrl.getEstdName(), enrl.getEstdAddress(),
				enrl.getTaxCircle().getCircleName(), enrl.getEmployeeTypes().getTypeName(), efeView, opowView, eaView);

		return enrlView;
	}

	@Override
	public CitizenHomePayload getPayload(String id) {
		CitizenHomePayload payload = new CitizenHomePayload();

		Boolean exist = registrationApplicationFormRepository.existsByCitizenIdStatus(Integer.parseInt(id));

		if (exist == null) {
			payload.setRegtApp(true);
		} else {
			payload.setRegtApp(exist);
		}

		payload.setRegt(registrationRepository.existsByCitizenCitizenId(Integer.parseInt(id)));

		Boolean exist2 = enrollmentApplicationFormRepository.existsByCitizenIdStatus(Integer.parseInt(id));

		if (exist2 == null) {
			payload.setEnrlApp(true);
		} else {
			payload.setEnrlApp(exist2);
		}

		payload.setEnrl(enrollmentRepository.existsByCitizenCitizenId(Integer.parseInt(id)));

		return payload;
	}

	@Override
	public ResponseEntity<?> regtCancellation(RegtCancelApp regtCancelApp) {
		RegistrationCancellationApplicaiton rca = new RegistrationCancellationApplicaiton();
		rca.setCitizen(regtCancelApp.getCitizen());
		rca.setRegistration(regtCancelApp.getRegistration());
		rca.setStatus(false);
		rca.setRequestDate(LocalDate.now());
		regtCancelAppRepository.save(rca);
		return ResponseEntity.ok(new MessageResponse("Application successful!"));
	}

}
