package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	Boolean existsByCitizenCitizenId(Integer id);

	@Query("SELECT en FROM Enrollment en WHERE en.citizen.citizenId = ?1 AND en.status = true")
	Enrollment findByEnrlIdAndStatus(Integer id);
}
