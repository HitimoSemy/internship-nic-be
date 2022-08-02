package nic.taxes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

	Optional<Citizen> findByLoginName(String loginName);

	Boolean existsByLoginName(String loginName);
}
