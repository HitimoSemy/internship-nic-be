package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EnrollmentApplicationActs;

@Repository
public interface EnrollmentApplicationActsRepository extends JpaRepository<EnrollmentApplicationActs, Integer> {

	@Query("SELECT ALL eaa FROM EnrollmentApplicationActs eaa WHERE eaa.enrollmentApplicationForm.appId=?1")
	List<EnrollmentApplicationActs> findAllByEnrolmentApplicationFormAppId(Integer id);

}
