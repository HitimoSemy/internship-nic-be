package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nic.taxes.entity.EnrollmentOtherPlaceOfWork;

public interface EnrollmentOtherWorkplacesRepository extends JpaRepository<EnrollmentOtherPlaceOfWork, Integer> {

	@Query("SELECT ALL efe FROM EnrollmentOtherPlaceOfWork efe WHERE efe.enrollment.enrlId=?1")
	List<EnrollmentOtherPlaceOfWork> findAllByEnrollmentEnrlId(Integer enrlId);

}
