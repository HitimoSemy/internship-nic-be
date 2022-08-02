package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EmployeeTypes;

@Repository
public interface EmployeeTypesRepository extends JpaRepository<EmployeeTypes, Integer> {

}
