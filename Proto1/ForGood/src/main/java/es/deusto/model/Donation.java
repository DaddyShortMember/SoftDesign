package es.deusto.model;

import jakarta.persistence.*;

@Entity
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int amount;
	private String msg;

	public Donation() {
	}

	public Donation(int value, String mes) {
		this.amount = value;
		this.msg = mes;
	}
	
	public Donation(int value) {
		this.amount = value;
	}
	
	public Donation(Long id, int value) {
		this.id = id;
		this.amount = value;
	}
	
	public Donation(Long id, int value, String mes) {
		this.id = id;
		this.amount = value;
		this.msg = mes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int value) {
		this.amount = value;
	}

}
