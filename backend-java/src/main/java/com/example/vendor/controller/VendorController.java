package com.example.vendor.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendor.model.Vendor;
import com.example.vendor.service.VendorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

	@PostMapping
	public ResponseEntity<?> createVendor(@Valid @RequestBody Vendor vendor) {
		if (vendorService.checkExistsByEmail(vendor.getEmail())) {
			Map<String, String> response = new HashMap<>();
			response.put("message",String.format("The provided email address '%s' already registered.", vendor.getEmail()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		Vendor createdVendor = vendorService.createVendor(vendor);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
	}
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> deleteVendor(@PathVariable Long id) {
		Vendor deletedVendor = vendorService.deleteVendor(id);
		/**
		 * Instead of return map, we can also return the custom api response, which can
		 * hold any data with status code and message
		 */
		return ResponseEntity.ok(Map.of("status", HttpStatus.OK.value(), "message",deletedVendor.getName()+ " Vendor deleted successfully !",
				"deletedVendor", deletedVendor));
	}
}