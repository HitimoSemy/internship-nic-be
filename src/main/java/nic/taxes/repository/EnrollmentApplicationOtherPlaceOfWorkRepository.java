package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EnrollmentApplicationOtherPlaceOfWork;

@Repository
public interface EnrollmentApplicationOtherPlaceOfWorkRepository
		extends JpaRepository<EnrollmentApplicationOtherPlaceOfWork, Integer> {

	@Query("SELECT ALL eaa FROM EnrollmentApplicationOtherPlaceOfWork eaa WHERE eaa.enrollmentApplicationForm.appId=?1")
	List<EnrollmentApplicationOtherPlaceOfWork> findAllByEnrolmentApplicationFormAppId(Integer id);

}
