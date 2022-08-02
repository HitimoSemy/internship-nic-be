package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationApplicationExtraEstablishment;

@Repository
public interface RegistrationApplicationExtraEstablishmentRepository
		extends JpaRepository<RegistrationApplicationExtraEstablishment, Integer> {

	@Query("SELECT ALL raee FROM RegistrationApplicationExtraEstablishment raee WHERE raee.registrationApplicationForm.appId=?1")
	List<RegistrationApplicationExtraEstablishment> findAllByRegistrationApplicationFormAppId(Integer id);

}
