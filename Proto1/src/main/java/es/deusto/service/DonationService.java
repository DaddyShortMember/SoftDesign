package es.deusto.service;

import org.springframework.stereotype.Service;

import es.deusto.model.Donation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DonationService {

	// Auxiliary map to store the Donations as a repository.
    private final Map<Long, Donation> Donations = new HashMap<>();
    // AtomicLong to generate unique IDs for the Donations.
    private final AtomicLong idGenerator = new AtomicLong(0);

    public DonationService() {
        // Pre-populate the map with some Donations.        
    	Donation Donation = new Donation(idGenerator.incrementAndGet(), 2);
    	Donations.put(Donation.getId(), Donation);
    	Donation = new Donation(idGenerator.incrementAndGet(), 3, "Let's give hope to the hopeless!");
        Donations.put(Donation.getId(), Donation);
    }

    public List<Donation> getAllDonations() {        
    	return new ArrayList<>(Donations.values());    	
    }
    
	public Optional<Donation> getDonationByValue(int value) {
		for (Donation Donation : Donations.values()) {
			if (Donation.getAmount() == value) {
				return Optional.of(Donation);
			}
		}
		
		return Optional.empty();
	}

	public Donation createDonation(Donation Donation) {
		Donation.setId(idGenerator.incrementAndGet());
		Donations.put(Donation.getId(), Donation);

		return Donation;
    }

    public Optional<Donation> updateDonation(Long id, Donation Donation) {
        if (Donations.containsKey(id)) {
			Donation existingDonation = Donations.get(id);
			existingDonation.setMessage(Donation.getMessage());
			// NOT LETTING THE AMOUNT CHANGE.
			return Optional.of(existingDonation);
        } else {
        	return Optional.empty();
        }   
    }

    public boolean deleteDonation(Long id) {
        return Donations.remove(id) != null;
    }
}
