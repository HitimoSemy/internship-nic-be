package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationExtraEstablishment;

@Repository
public interface RegistrationExtraEstablishmentRepository
		extends JpaRepository<RegistrationExtraEstablishment, Integer> {

	@Query("SELECT ALL ree FROM RegistrationExtraEstablishment ree WHERE ree.registration.regtId=?1")
	List<RegistrationExtraEstablishment> findAllByRegisrationRegtId(Integer regtId);

}
