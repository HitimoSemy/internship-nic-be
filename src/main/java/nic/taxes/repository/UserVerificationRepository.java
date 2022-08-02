package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.UserVerificationEntity;

@Repository
public interface UserVerificationRepository extends JpaRepository<UserVerificationEntity, String> {
	UserVerificationEntity findByEmail(String email);

	Boolean existsByEmail(String email);

	void deleteById(String email);
}
