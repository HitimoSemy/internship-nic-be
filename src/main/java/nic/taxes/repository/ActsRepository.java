package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.Acts;

@Repository
public interface ActsRepository extends JpaRepository<Acts, Integer> {

}
