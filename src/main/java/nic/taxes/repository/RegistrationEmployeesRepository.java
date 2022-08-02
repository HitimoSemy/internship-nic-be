package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationEmployees;

@Repository
public interface RegistrationEmployeesRepository extends JpaRepository<RegistrationEmployees, Integer> {

	@Query("SELECT ALL re FROM RegistrationEmployees re WHERE re.registration.regtId=?1")
	List<RegistrationEmployees> findAllByRegistrationRegtId(Integer regtId);

}
