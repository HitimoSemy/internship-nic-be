package nic.taxes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nic.taxes.entity.TaxCircle;

@Repository
public interface TaxCircleRepository extends JpaRepository<TaxCircle, Integer> {
	List<TaxCircle> findAllByDistrictDistId(Integer id);
}
