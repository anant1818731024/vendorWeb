package com.anant.spring.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.spring.boot.entities.Vendor;
import com.anant.spring.boot.repos.VendorRepository;
import com.anant.spring.boot.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;
	

	@Override
	public Vendor createVendor(Vendor vendor) {
		return repo.save(vendor);
	}
	
	@Override
	public Vendor updateVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		repo.delete(vendor);
	}

	@Override
	public Vendor getVendorById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Vendor> getVendors() {
		return repo.findAll();
	}

}
