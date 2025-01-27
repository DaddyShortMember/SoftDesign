package es.deusto.dto;

import java.util.Objects;

public class DonationDTO {

	private Long id;
	private String name;
	private String description;
	// Default constructor is needed for Jackson to deserialize JSON
	public DonationDTO() { }
	
	// Constructor without id for creating new Campaignes using POST
	public DonationDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	// Constructor with all attributes
	public DonationDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Equals and HashCode methods
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DonationDTO other = (DonationDTO) obj;
		return Objects.equals(id, other.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}	
}