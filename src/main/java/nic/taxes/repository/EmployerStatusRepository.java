package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EmployerStatus;

@Repository
public interface EmployerStatusRepository extends JpaRepository<EmployerStatus, Integer> {

}
