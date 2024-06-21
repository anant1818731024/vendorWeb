package com.anant.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anant.spring.boot.entities.Vendor;
import com.anant.spring.boot.repos.VendorRepository;

@RestController
public class VendorRestController {
	
	@Autowired
	private VendorRepository vendorRepo;

	@GetMapping("/vendors/{id}")
	public Vendor getVendor(@PathVariable("id") int id) {
		return vendorRepo.findById(id).get();
	}
	
	@PostMapping("/vendors")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@PutMapping("/vendors")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@DeleteMapping("/vendors/{id}")
	public void deleteVendor(@PathVariable("id") int id) {
		vendorRepo.deleteById(id);
	}
	
	@GetMapping("/vendors")
	public List<Vendor> getVendors() {
		return vendorRepo.findAll();
	}
}
