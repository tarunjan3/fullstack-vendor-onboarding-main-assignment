package com.example.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendor.exception.ResourceNotFoundException;
import com.example.vendor.model.Vendor;
import com.example.vendor.repository.VendorRepository;

@Service
public class VendorService {

	private final VendorRepository vendorRepository;

	@Autowired
	public VendorService(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}

	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}

	public Vendor createVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	public Vendor deleteVendor(Long id) {
		Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor", id));
		vendorRepository.delete(vendor);
		return vendor; // return deleted entity for response

	}

	public boolean checkExistsByEmail(String email) {
		return vendorRepository.existsByEmail(email);
	}
}