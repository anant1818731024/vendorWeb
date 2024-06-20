package com.anant.spring.boot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anant.spring.boot.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	@Query("SELECT v.type, COUNT(v.type) FROM Vendor v GROUP BY v.type")
	public List<Object[]> findTypeAndTypeCount();
}
