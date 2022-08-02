package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationActs;

@Repository
public interface RegistrationActsRepository extends JpaRepository<RegistrationActs, Integer> {

	@Query("SELECT ALL ra FROM RegistrationActs ra WHERE ra.registration.regtId=?1")
	List<RegistrationActs> findAllByRegistraitonRegtId(Integer regtId);

}
