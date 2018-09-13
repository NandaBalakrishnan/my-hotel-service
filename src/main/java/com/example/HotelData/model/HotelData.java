package com.example.HotelData.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HotelDetails")
public class HotelData {
	@Id
	int hotelId;
	private String name;
	private String description;
	String city;
	private int rating;

	public HotelData(int hotelId, String name, String description, String city, int rating) {
		this.hotelId = hotelId;
		this.name = name;
		this.description = description;
		this.city = city;
		this.rating = rating;
	}

	@JsonProperty("hotelId")
	public int getHotelId() {
		return hotelId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("rating")
	public int getRating() {
		return rating;
	}


}
