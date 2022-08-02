package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	Boolean existsByCitizenCitizenId(Integer id);

	@Query("SELECT re FROM Registration re WHERE re.citizen.citizenId = ?1 AND re.status = true")
	Registration findByRegtIdAndStatus(Integer id);
}
