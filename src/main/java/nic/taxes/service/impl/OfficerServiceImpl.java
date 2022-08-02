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
import nic.taxes.entity.EnrollmentApplicationActs;
import nic.taxes.entity.EnrollmentApplicationForeignEmployer;
import nic.taxes.entity.EnrollmentApplicationForm;
import nic.taxes.entity.EnrollmentApplicationOtherPlaceOfWork;
import nic.taxes.entity.EnrollmentForeignEmployer;
import nic.taxes.entity.EnrollmentOtherPlaceOfWork;
import nic.taxes.entity.Officer;
import nic.taxes.entity.Registration;
import nic.taxes.entity.RegistrationActs;
import nic.taxes.entity.RegistrationApplicationActs;
import nic.taxes.entity.RegistrationApplicationEmployeeList;
import nic.taxes.entity.RegistrationApplicationExtraEstablishment;
import nic.taxes.entity.RegistrationApplicationForm;
import nic.taxes.entity.RegistrationEmployees;
import nic.taxes.entity.RegistrationExtraEstablishment;
import nic.taxes.model.ApproveEnrlNoEdit;
import nic.taxes.model.ApproveRegtNoEdit;
import nic.taxes.model.EnrollmentActsView;
import nic.taxes.model.EnrollmentApplicationFormView;
import nic.taxes.model.EnrollmentForeignEmployerView;
import nic.taxes.model.EnrollmentOtherPlaceOfWorkView;
import nic.taxes.model.ListOfNewEnrollments;
import nic.taxes.model.ListOfNewRegistrations;
import nic.taxes.model.MessageResponse;
import nic.taxes.model.RegistrationActsListView;
import nic.taxes.model.RegistrationApplicationFormView;
import nic.taxes.model.RegistrationEmployeeListView;
import nic.taxes.model.RegistrationExtraEstdListView;
import nic.taxes.repository.EnrollmentApplicationActsRepository;
import nic.taxes.repository.EnrollmentApplicationForeignEmployerRepository;
import nic.taxes.repository.EnrollmentApplicationFormRepository;
import nic.taxes.repository.EnrollmentApplicationOtherPlaceOfWorkRepository;
import nic.taxes.repository.EnrollmentRepository;
import nic.taxes.repository.OfficerRepository;
import nic.taxes.repository.RegistrationApplicationActsRepository;
import nic.taxes.repository.RegistrationApplicationEmployeeListRepository;
import nic.taxes.repository.RegistrationApplicationExtraEstablishmentRepository;
import nic.taxes.repository.RegistrationApplicationFormRepository;
import nic.taxes.repository.RegistrationRepository;
import nic.taxes.service.OfficerService;

@Service
public class OfficerServiceImpl implements OfficerService {

	@Autowired
	private OfficerRepository officerRepository;

	@Autowired
	private RegistrationApplicationFormRepository registrationApplicationFormRepository;

	@Autowired
	private RegistrationApplicationEmployeeListRepository registrationApplicationEmployeeListRepository;

	@Autowired
	private RegistrationApplicationActsRepository registrationApplicationActsRepository;

	@Autowired
	private RegistrationApplicationExtraEstablishmentRepository registrationApplicationExtraEstablishmentRepository;

	@Autowired
	private RegistrationRepository registrationRepository;

//	@Autowired
//	private RegistrationCancellationApplicationRepository registrationCancellationApplicationRepository;

	@Autowired
	private EnrollmentApplicationFormRepository enrollmentApplicationFormRepository;

	@Autowired
	private EnrollmentApplicationActsRepository enrollmentApplicationActsRepository;

	@Autowired
	private EnrollmentApplicationOtherPlaceOfWorkRepository enrollmentApplicationOtherPlaceOfWorkRepository;

	@Autowired
	private EnrollmentApplicationForeignEmployerRepository enrollmentApplicationForeignEmployerRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public List<ListOfNewRegistrations> getAllRegistrationApplicationForms(String id) {
		List<RegistrationApplicationForm> listOfRegistrations = registrationApplicationFormRepository
				.getAllByTaxCircleCircleIdAndStatus(Integer.parseInt(id));

		List<ListOfNewRegistrations> listModel = listOfRegistrations.stream()
				.map(listData -> new ListOfNewRegistrations(listData.getAppId(), listData.getApplicantName(),
						listData.getAppDate()))
				.collect(Collectors.toList());

		return listModel;
	}

	@Override
	public RegistrationApplicationFormView viewRegistrationForm(String id) {
		RegistrationApplicationForm form = registrationApplicationFormRepository.getByAppId(Integer.parseInt(id));

		List<RegistrationApplicationEmployeeList> employeeList = registrationApplicationEmployeeListRepository
				.findAllByRegistrationApplicationFormAppId(Integer.parseInt(id));

		List<RegistrationEmployeeListView> empList = employeeList.stream()
				.map(data -> new RegistrationEmployeeListView(data.getEmployeeName(),
						data.getEmployeeStatus().getStatusId(), data.getEmployeeGrossPay(), data.getEmployeeGrossPay()))
				.collect(Collectors.toList());

		List<RegistrationApplicationActs> actsList = registrationApplicationActsRepository
				.findAllByRegistrationApplicationFormAppId(Integer.parseInt(id));

		List<RegistrationActsListView> aList = actsList.stream()
				.map(data -> new RegistrationActsListView(data.getActs().getActCode(),
						data.getCertificateRegistrationNumber(), data.getLogDate()))
				.collect(Collectors.toList());

		List<RegistrationApplicationExtraEstablishment> estdList = registrationApplicationExtraEstablishmentRepository
				.findAllByRegistrationApplicationFormAppId(Integer.parseInt(id));

		List<RegistrationExtraEstdListView> elist = estdList.stream()
				.map(data -> new RegistrationExtraEstdListView(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		RegistrationApplicationFormView model = new RegistrationApplicationFormView(form.getApplicantName(),
				form.getAddress(), form.getPincode(), form.getAppId(), form.getEmployerStatus().getStatusName(),
				form.getAppDate(), form.getEstdName(), form.getEstdAddress(), form.getDistrict().getDistName(),
				form.getTaxCircle().getCircleName(), form.getEmployerClass().getClassName(), form.getEstdDescr(),
				empList, aList, elist);
		return model;
	}

	@Override
	public List<ListOfNewEnrollments> getAllEnrollmentApplicationForms(String id) {
		List<EnrollmentApplicationForm> forms = enrollmentApplicationFormRepository
				.getAllByTaxCircleCircleId(Integer.parseInt(id));

		List<ListOfNewEnrollments> listModel = forms.stream()
				.map(data -> new ListOfNewEnrollments(data.getAppId(), data.getApplicantName(), data.getAppDate()))
				.collect(Collectors.toList());
		return listModel;
	}

//	@Override
//	public List<ListOfRegistrationCancellations> getAllRegistrationCancellationApplications(String id) {
//		List<RegistrationCancellationApplicaiton> cncls = registrationCancellationApplicationRepository
//				.getAllByTaxCircleCircleId(Integer.parseInt(id));
//
//		List<ListOfRegistrationCancellations> cancellations = cncls.stream()
//				.map(data -> new ListOfRegistrationCancellations(data.getRegistration().getApplicantName(),
//						data.getRequestDate()))
//				.collect(Collectors.toList());
//		return cancellations;
//	} 
// create a repository for regisrationcancellationapplication

	@Override
	public EnrollmentApplicationFormView viewEnrollment(String id) {
		EnrollmentApplicationForm form = enrollmentApplicationFormRepository.getByAppId(Integer.parseInt(id));

		List<EnrollmentApplicationActs> actsList = enrollmentApplicationActsRepository
				.findAllByEnrolmentApplicationFormAppId(Integer.parseInt(id));

		List<EnrollmentActsView> acts = actsList.stream()
				.map(data -> new EnrollmentActsView(data.getActs().getActCode(),
						data.getCertificateRegistrationNumber(), data.getLogDate()))
				.collect(Collectors.toList());

		List<EnrollmentApplicationOtherPlaceOfWork> otherPowlist = enrollmentApplicationOtherPlaceOfWorkRepository
				.findAllByEnrolmentApplicationFormAppId(Integer.parseInt(id));

		List<EnrollmentOtherPlaceOfWorkView> otherPow = otherPowlist.stream()
				.map(data -> new EnrollmentOtherPlaceOfWorkView(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		List<EnrollmentApplicationForeignEmployer> employersList = enrollmentApplicationForeignEmployerRepository
				.findAllByEnrolmentApplicationFormAppId(Integer.parseInt(id));

		List<EnrollmentForeignEmployerView> employers = employersList.stream()
				.map(data -> new EnrollmentForeignEmployerView(data.getEmployerName(), data.getEmployerAddress(),
						data.getMonthlyPay()))
				.collect(Collectors.toList());

		EnrollmentApplicationFormView model = new EnrollmentApplicationFormView(form.getAppDate(), form.getAppId(),
				form.getApplicantName(), form.getEstdName(), form.getEstdAddress(), form.getDistrict().getDistName(),
				form.getPincode(), form.getTaxCircle().getCircleName(), form.getEstdDescr(),
				form.getEmployeeTypes().getTypeName(), form.getDateOfCommence(), form.getGrossAnnual(), employers,
				form.getPlaceOfWork(), otherPow, form.getBranchCertNos(), acts);

		return model;
	}

	@Override
	public ResponseEntity<?> approveRegtNoEdit(ApproveRegtNoEdit approveRegtNoEdit) {
		RegistrationApplicationForm form = registrationApplicationFormRepository
				.getByAppId(approveRegtNoEdit.getRegtId());
		Officer off = officerRepository.getByOfficerId(approveRegtNoEdit.getOfficerId());

		Registration regt = new Registration();

		BeanUtils.copyProperties(form, regt);

		regt.setRegistrationApplicationForm(form);

		List<RegistrationActs> acts = form.getRegistrationApplicationActs().stream()
				.map(data -> new RegistrationActs(data.getActs(), data.getCertificateRegistrationNumber(),
						data.getLogDate()))
				.collect(Collectors.toList());
		acts.forEach(data -> data.setRegistration(regt));

		List<RegistrationEmployees> emps = form
				.getRegistrationEmployeeLists().stream().map(data -> new RegistrationEmployees(data.getEmployeeName(),
						data.getEmployeeStatus(), data.getEmployeeGrossPay(), data.getEmployeeTaxPayable()))
				.collect(Collectors.toList());

		emps.forEach(data -> data.setRegistration(regt));

		List<RegistrationExtraEstablishment> estds = form.getRegistrationApplicationExtraEstablishments().stream()
				.map(data -> new RegistrationExtraEstablishment(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		estds.forEach(data -> data.setRegistration(regt));

		regt.setRegistrationActs(acts);
		regt.setRegistrationEmployees(emps);
		regt.setRegistrationExtraEstablishments(estds);

		regt.setRegistrationApplicationForm(form);

		regt.setStatus(true);
		regt.setApprovalDate(LocalDate.now());
		regt.setOfficer(off);

		registrationRepository.save(regt);

		form.setStatus(true);
		registrationApplicationFormRepository.save(form);

		return ResponseEntity.ok(new MessageResponse("Registration Approved!"));
	}

	@Override
	public ResponseEntity<?> approveEnrlNoEdit(ApproveEnrlNoEdit approveEnrlNoEdit) {
		EnrollmentApplicationForm form = enrollmentApplicationFormRepository.getByAppId(approveEnrlNoEdit.getEnrlId());

		Officer off = officerRepository.getByOfficerId(approveEnrlNoEdit.getOfficerId());

		Enrollment enrl = new Enrollment();

		BeanUtils.copyProperties(form, enrl);

		enrl.setEnrollmentApplicationForm(form);

		List<EnrollmentActs> acts = form.getEnrollmentApplicationActs().stream().map(
				data -> new EnrollmentActs(data.getActs(), data.getCertificateRegistrationNumber(), data.getLogDate()))
				.collect(Collectors.toList());

		acts.forEach(data -> data.setEnrollment(enrl));

		List<EnrollmentForeignEmployer> empl = form.getEnrollmentApplicationForeignEmployers().stream()
				.map(data -> new EnrollmentForeignEmployer(data.getEmployerName(), data.getEmployerAddress(),
						data.getMonthlyPay()))
				.collect(Collectors.toList());

		empl.forEach(data -> data.setEnrollment(enrl));

		List<EnrollmentOtherPlaceOfWork> pow = form.getEnrollmentApplicationOtherPLaceOfWorks().stream()
				.map(data -> new EnrollmentOtherPlaceOfWork(data.getEstdName(), data.getEstdAddress()))
				.collect(Collectors.toList());

		pow.forEach(data -> data.setEnrollment(enrl));

		enrl.setEnrollmentActs(acts);
		enrl.setEnrollmentForeignEmployers(empl);
		enrl.setEnrollmentOtherPlaceOfWorks(pow);

		enrl.setEnrollmentApplicationForm(form);

		enrl.setStatus(true);
		enrl.setAppDate(LocalDate.now());
		enrl.setOfficer(off);

		enrollmentRepository.save(enrl);

		form.setStatus(true);
		enrollmentApplicationFormRepository.save(form);

		return ResponseEntity.ok(new MessageResponse("Enrollment Approved!"));
	}

}
