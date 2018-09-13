package com.example.test.HotelData.service;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.HotelData.dao.HotelDataRespository;
import com.example.HotelData.model.HotelData;
import com.example.HotelData.service.HotelDataService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { HotelDataService.class })
public class HotelDataApplicationTests {
	@Autowired
	HotelDataService hotelDataService;

	@MockBean
	private HotelDataRespository hotelDataRespository;

	@Test
	public void addHotelDataTest() {
		HotelData hotelData = new HotelData(1, "IBIS", "testDesc", "testCity", 2);
		Mockito.when(hotelDataRespository.save(hotelData)).thenReturn(hotelData);
		HotelData response = hotelDataService.createHotel(hotelData);
		assert (response.getHotelId() == hotelData.getHotelId());
		assert (response.getName().matches(hotelData.getName()));
		assert (response.getDescription().matches(hotelData.getDescription()));
		assert (response.getCity().matches(hotelData.getCity()));
		assert (response.getRating() == hotelData.getRating());
	}

	@Test
	public void updateHotelDataTest() {
		HotelData hotelData = new HotelData(1, "IBIS", "testDesc", "testCity", 2);
		Mockito.when(hotelDataRespository.existsById(hotelData.getHotelId())).thenReturn(true);
		Mockito.when(hotelDataRespository.save(hotelData)).thenReturn(hotelData);
		HotelData response = hotelDataService.updateHotel(hotelData);
		assert (response.getHotelId() == hotelData.getHotelId());
		assert (response.getName().matches(hotelData.getName()));
		assert (response.getDescription().matches(hotelData.getDescription()));
		assert (response.getCity().matches(hotelData.getCity()));
		assert (response.getRating() == hotelData.getRating());
	}

	@Test
	public void getAllHotelDataTest() {
		HotelData hotelData = new HotelData(1, "IBIS", "testDesc", "testCity", 2);
		List<HotelData> list = new ArrayList<>();
		list.add(hotelData);
		Mockito.when(hotelDataRespository.findAll()).thenReturn(list);
		List<HotelData> response = hotelDataService.getAllHotels();
		assert (response.size() == 1);
		assert (response.get(0).getHotelId() == list.get(0).getHotelId());
		assert (response.get(0).getName().matches(list.get(0).getName()));
		assert (response.get(0).getDescription().matches(list.get(0).getDescription()));
		assert (response.get(0).getCity().matches(list.get(0).getCity()));
		assert (response.get(0).getRating() == list.get(0).getRating());
		
	}
}
