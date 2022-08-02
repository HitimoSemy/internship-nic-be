package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nic.taxes.entity.RegistrationCancellationApplicaiton;

public interface RegtCancelAppRepository extends JpaRepository<RegistrationCancellationApplicaiton, Integer> {

}
