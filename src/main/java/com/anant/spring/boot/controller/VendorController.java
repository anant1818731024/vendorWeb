package com.anant.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anant.spring.boot.entities.Vendor;
import com.anant.spring.boot.repos.VendorRepository;
import com.anant.spring.boot.service.VendorService;
import com.anant.spring.boot.util.EmailUtil;
import com.anant.spring.boot.util.EmailUtilImpl;
import com.anant.spring.boot.util.ReportUtil;

import jakarta.servlet.ServletContext;

@Controller
public class VendorController {

	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private VendorService service;
	
	@Autowired
	private VendorRepository repo;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/showCreateVendor")
	public String showCreateVendor() {
		return "createVendor";
	}
	
	@PostMapping("/saveVendor")
	public String saveVendor(Vendor vendor) {
		service.createVendor(vendor);
		emailUtil.sendEmail("avashishtha2000@gmail.com", "Vendor Saved", "Vendor saved succefully and about to return a response");
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
	
	
	@GetMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		
		List<Object[]> data = repo.findTypeAndTypeCount();
		
		String completeFilePath = reportUtil.generatePieChart(path, data);

		return "report";
	}
}
