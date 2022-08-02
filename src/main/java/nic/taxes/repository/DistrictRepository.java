package nic.taxes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
