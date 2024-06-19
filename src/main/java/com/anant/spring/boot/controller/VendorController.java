package com.anant.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anant.spring.boot.entities.Vendor;
import com.anant.spring.boot.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	private VendorService service;
	
	@GetMapping("/showCreateVendor")
	public String showCreateVendor() {
		return "createVendor";
	}
	
	@PostMapping("/saveVendor")
	public String saveVendor(Vendor vendor) {
		service.createVendor(vendor);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String displayVendors(ModelMap modelMap) {
		modelMap.addAttribute("vendors", service.getVendors());
		return "displayVendors";
	}
	
	@GetMapping("/showUpdate")
	public String showUpdateVendor(@RequestParam int id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@PostMapping("/updateVendor")
	public String updateVendor(Vendor vendor) {
		service.updateVendor(vendor);
		return "redirect:/";
	}

	
	@GetMapping("/deleteVendor")
	public String deleteVendor(@RequestParam int id) {
		Vendor vendor = service.getVendorById(id);
		service.deleteVendor(vendor);
		return "redirect:/";
	}
	
}
