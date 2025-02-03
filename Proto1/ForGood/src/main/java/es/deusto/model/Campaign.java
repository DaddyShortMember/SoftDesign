/**
 * Derivative of code provided by ChatGPT 4o
 */

package es.deusto.model;

import java.util.Objects;

public class Campaign {

	private Long id;
	private String name;
	private String description;
	private String start;
	private String end;
	private float target;
	private float current;
	private String country;
	// Default constructor is needed for Jackson to deserialize JSON
	public Campaign() { }
	
	// Constructor without id for creating new Campaignes using POST
	public Campaign(String name, String description, String start, String end, float target, String country) {
		super();
		this.name = name;
		this.description = description;
		this.country = country;
		this.current = 0;
		this.start = start;
		this.end = end;
		this.target = target;
	}

	// Constructor with all attributes
	public Campaign(Long id, String name, String description, String start, String end, float target, String country) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.country = country;
		this.current = 0;
		this.start = start;
		this.end = end;
		this.target = target;
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public float getTarget() {
		return target;
	}

	public void setTarget(float target) {
		this.target = target;
	}

	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
		Campaign other = (Campaign) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}	
}