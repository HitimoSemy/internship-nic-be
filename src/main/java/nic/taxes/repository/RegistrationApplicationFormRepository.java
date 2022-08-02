package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationApplicationForm;

@Repository
public interface RegistrationApplicationFormRepository extends JpaRepository<RegistrationApplicationForm, Integer> {

	@Query("SELECT ra FROM RegistrationApplicationForm ra WHERE ra.taxCircle.circleId = ?1 AND ra.status = false")
	List<RegistrationApplicationForm> getAllByTaxCircleCircleIdAndStatus(Integer id);

	RegistrationApplicationForm getByAppId(Integer id);

	@Query("SELECT ra.status FROM RegistrationApplicationForm ra WHERE ra.citizen.citizenId = ?1 AND ra.status = false")
	Boolean existsByCitizenIdStatus(Integer id);

	Boolean existsByCitizenCitizenId(Integer id);

}
