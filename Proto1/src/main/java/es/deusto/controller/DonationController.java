package es.deusto.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.deusto.service.DonationService;
import es.deusto.model.Donation;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Donations")
public class DonationController {

    private final DonationService DonationService;

    public DonationController(DonationService DonationService) {
        this.DonationService = DonationService;
    }

    // Get all Donations
    @GetMapping
    public ResponseEntity<List<Donation>> getAllDonations() {        
        return new ResponseEntity<>(DonationService.getAllDonations(), HttpStatus.OK);
    }

    // Create a new Donation
    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody Donation Donation) {
        Donation newDonation = DonationService.createDonation(Donation);
        
        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
    }

    // Update an existing Donation
    @PutMapping("/{id}")
    public ResponseEntity<Donation> updateDonation(@PathVariable("id") Long id, @RequestBody Donation Donation) {
        Optional<Donation> updatedDonation = DonationService.updateDonation(id, Donation);
        
        if (updatedDonation.isPresent()) {
            return new ResponseEntity<>(updatedDonation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Donation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable("id") Long id) {
        boolean deleted = DonationService.deleteDonation(id);
        
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}