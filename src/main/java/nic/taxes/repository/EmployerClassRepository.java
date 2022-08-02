package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.EmployerClass;

@Repository
public interface EmployerClassRepository extends JpaRepository<EmployerClass, Integer> {

}
