package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nic.taxes.entity.EnrollmentForeignEmployer;

public interface EnrollmentForeignEmployerRepository extends JpaRepository<EnrollmentForeignEmployer, Integer> {

	@Query("SELECT ALL efe FROM EnrollmentForeignEmployer efe WHERE efe.enrollment.enrlId=?1")
	List<EnrollmentForeignEmployer> findAllByEnrollmentEnrlId(Integer id);

}
