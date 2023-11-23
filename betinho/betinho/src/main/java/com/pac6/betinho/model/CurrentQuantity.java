package com.pac6.betinho.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CURRENT_QUANTITY", schema = "public")
public class CurrentQuantity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scheduled")
	private Long id;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@Column(name = "grams")
	private Float grams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Float getGrams() {
		return grams;
	}

	public void setGrams(Float grams) {
		this.grams = grams;
	}
}
