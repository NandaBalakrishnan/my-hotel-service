package com.example.HotelData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelData.dao.HotelDataRespository;
import com.example.HotelData.model.HotelData;

@Service
public class HotelDataService {

	@Autowired
	private HotelDataRespository hotelDataRespository;

	public HotelData createHotel(HotelData hotelData) {
		if (hotelData != null) {
			if (hotelDataRespository.existsById(hotelData.getHotelId())) {
				System.out.println("The hotel with same ID exists");
				return null;
			} else {
				System.out.println("New Hotel Added");
				return hotelDataRespository.save(hotelData);
			}
		} else
			return null;
	}

	public HotelData updateHotel(HotelData hotelData) {
		if (hotelData != null) {
			if (!hotelDataRespository.existsById(hotelData.getHotelId())) {
				System.out.println("No hotel with the given ID exists");
				return null;
			} else {
				System.out.println("Hotel details updated");
				return hotelDataRespository.save(hotelData);
			}
		} else
			return null;
	}

	public HotelData getHotel(int hotelId) {
		if (!hotelDataRespository.existsById(hotelId)) {
			System.out.println("No hotel with the given ID exists");
			return null;
		} else {
			return hotelDataRespository.findById(hotelId).get();
		}
	}

	public List<HotelData> getAllHotels() {
		return hotelDataRespository.findAll();
	}

	public String deleteHotel(int hotelId) {
		if (!hotelDataRespository.existsById(hotelId)) {
			System.out.println("No hotel with the given ID exists");
			return null;
		} else {
			System.out.println("Hotel Deleted");
			hotelDataRespository.deleteById(hotelId);
			return "Deleted the hotel " + hotelId;
		}
	}
}
