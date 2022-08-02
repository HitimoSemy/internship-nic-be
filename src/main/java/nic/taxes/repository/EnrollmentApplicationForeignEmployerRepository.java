package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EnrollmentApplicationForeignEmployer;

@Repository
public interface EnrollmentApplicationForeignEmployerRepository
		extends JpaRepository<EnrollmentApplicationForeignEmployer, Integer> {

	@Query("SELECT ALL eafe FROM EnrollmentApplicationForeignEmployer eafe WHERE eafe.enrollmentApplicationForm.appId=?1")
	List<EnrollmentApplicationForeignEmployer> findAllByEnrolmentApplicationFormAppId(Integer id);

}
