package nic.taxes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.Officer;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {

	Optional<Officer> findByLoginName(String loginName);

	Boolean existsByLoginName(String loginName);

	Officer getByOfficerId(Integer officerId);
}
