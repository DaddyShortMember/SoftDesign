package es.deusto.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.deusto.service.CampaignService;
import es.deusto.model.Campaign;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Campaigns")
public class CampaignController {

    private final CampaignService CampaignService;

    public CampaignController(CampaignService CampaignService) {
        this.CampaignService = CampaignService;
    }

    // Get all Campaigns
    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {        
        return new ResponseEntity<>(CampaignService.getAllCampaigns(), HttpStatus.OK);
    }

    // Create a new Campaign
    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign Campaign) {
        Campaign newCampaign = CampaignService.createCampaign(Campaign);
        
        return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
    }

    // Update an existing Campaign
    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("id") Long id, @RequestBody Campaign Campaign) {
        Optional<Campaign> updatedCampaign = CampaignService.updateCampaign(id, Campaign);
        
        if (updatedCampaign.isPresent()) {
            return new ResponseEntity<>(updatedCampaign.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Campaign
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable("id") Long id) {
        boolean deleted = CampaignService.deleteCampaign(id);
        
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}