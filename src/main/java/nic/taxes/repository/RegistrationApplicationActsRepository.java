package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationApplicationActs;

@Repository
public interface RegistrationApplicationActsRepository extends JpaRepository<RegistrationApplicationActs, Integer> {

	@Query("SELECT ALL eaa FROM RegistrationApplicationActs eaa WHERE eaa.registrationApplicationForm.appId=?1")
	List<RegistrationApplicationActs> findAllByRegistrationApplicationFormAppId(Integer id);

}
