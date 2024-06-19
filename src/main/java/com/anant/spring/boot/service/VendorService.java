package com.anant.spring.boot.service;

import java.util.List;

import com.anant.spring.boot.entities.Vendor;

public interface VendorService {

	public Vendor createVendor(Vendor vendor);
	public Vendor updateVendor(Vendor vendor);
	public void deleteVendor(Vendor vendor);
	public Vendor getVendorById(int id);
	public List<Vendor> getVendors();
}
