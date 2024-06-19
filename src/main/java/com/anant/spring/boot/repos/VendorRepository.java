package com.anant.spring.boot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.spring.boot.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
