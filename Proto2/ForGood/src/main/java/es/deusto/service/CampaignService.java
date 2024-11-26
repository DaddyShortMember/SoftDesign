package es.deusto.service;

import org.springframework.stereotype.Service;

import es.deusto.model.Campaign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CampaignService {

	// Auxiliary map to store the Campaigns as a repository.
    private final Map<Long, Campaign> Campaigns = new HashMap<>();
    // AtomicLong to generate unique IDs for the Campaigns.
    private final AtomicLong idGenerator = new AtomicLong(0);

    public CampaignService() {
        // Pre-populate the map with some Campaigns.        
    	Campaign Campaign = new Campaign(idGenerator.incrementAndGet(), "JRS - Gaza", "Donate to the efforts of helping Palestinian refugees.");
    	Campaigns.put(Campaign.getId(), Campaign);
    	Campaign = new Campaign(idGenerator.incrementAndGet(), "RefInt - General Donation", "Fund our efforts to support refugees worldwide.");
        Campaigns.put(Campaign.getId(), Campaign);
        Campaign = new Campaign(idGenerator.incrementAndGet(), "JRS - Yemen", "Donate to the efforts of helping Yemeni refugees.");
        Campaigns.put(Campaign.getId(), Campaign);
        Campaign = new Campaign(idGenerator.incrementAndGet(), "RefInt - Demining Operations", "Fund our efforts to remove explosive mines.");
        Campaigns.put(Campaign.getId(), Campaign);
    }

    public List<Campaign> getAllCampaigns() {        
    	return new ArrayList<>(Campaigns.values());    	
    }
    
	public Optional<Campaign> getCampaignByName(String CampaignName) {
		for (Campaign Campaign : Campaigns.values()) {
			if (Campaign.getName().equalsIgnoreCase(CampaignName)) {
				return Optional.of(Campaign);
			}
		}
		
		return Optional.empty();
	}

	public Campaign createCampaign(Campaign Campaign) {
		Campaign.setId(idGenerator.incrementAndGet());
		Campaigns.put(Campaign.getId(), Campaign);

		return Campaign;
    }

    public Optional<Campaign> updateCampaign(Long id, Campaign Campaign) {
        if (Campaigns.containsKey(id)) {
			Campaign existingCampaign = Campaigns.get(id);
			existingCampaign.setName(Campaign.getName());
			existingCampaign.setDescription(Campaign.getDescription());

			return Optional.of(existingCampaign);
        } else {
        	return Optional.empty();
        }   
    }

    public boolean deleteCampaign(Long id) {
        return Campaigns.remove(id) != null;
    }
}
