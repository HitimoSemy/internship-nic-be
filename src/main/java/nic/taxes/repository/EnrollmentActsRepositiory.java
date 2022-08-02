package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nic.taxes.entity.EnrollmentActs;

public interface EnrollmentActsRepositiory extends JpaRepository<EnrollmentActs, Integer> {

	@Query("SELECT ALL efe FROM EnrollmentActs efe WHERE efe.enrollment.enrlId=?1")
	List<EnrollmentActs> findAllByEnrollmentEnrlId(Integer enrlId);

}
