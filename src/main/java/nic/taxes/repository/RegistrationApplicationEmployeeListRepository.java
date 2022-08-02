package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.RegistrationApplicationEmployeeList;

@Repository
public interface RegistrationApplicationEmployeeListRepository
		extends JpaRepository<RegistrationApplicationEmployeeList, Integer> {

	List<RegistrationApplicationEmployeeList> findAllByRegistrationApplicationFormAppId(Integer id);

}
