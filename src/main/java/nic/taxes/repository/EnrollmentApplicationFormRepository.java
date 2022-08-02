package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EnrollmentApplicationForm;

@Repository
public interface EnrollmentApplicationFormRepository extends JpaRepository<EnrollmentApplicationForm, Long> {

	@Query("SELECT ea FROM EnrollmentApplicationForm ea WHERE ea.taxCircle.circleId = ?1 AND ea.status = false")
	List<EnrollmentApplicationForm> getAllByTaxCircleCircleId(Integer id);

	EnrollmentApplicationForm getByAppId(Integer id);

	@Query("SELECT ea.status FROM EnrollmentApplicationForm ea WHERE ea.citizen.citizenId = ?1 AND ea.status = false")
	Boolean existsByCitizenIdStatus(Integer id);

	Boolean existsByCitizenCitizenId(Integer id);
}
