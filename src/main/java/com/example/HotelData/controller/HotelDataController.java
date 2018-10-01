package com.example.HotelData.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelData.model.HotelData;
import com.example.HotelData.service.HotelDataService;


@RestController
@RequestMapping("/hotels/details")
public class HotelDataController {
	@Autowired
	HotelDataService hotelDataService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelData> create(@RequestBody HotelData hotelData) throws UnsupportedEncodingException {
		HotelData response = null;
		response = hotelDataService.createHotel(hotelData);
		if (response == null) {
			return new ResponseEntity<HotelData>(response, HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<HotelData>(response, HttpStatus.CREATED);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelData> read(@PathVariable int hotelId) throws UnsupportedEncodingException {
		HotelData response = null;
		response = hotelDataService.getHotel(hotelId);
		if (response == null) {
			return new ResponseEntity<HotelData>(response, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<HotelData>(response, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelData>> readAll() throws UnsupportedEncodingException {
		List<HotelData> response = null;

		response = hotelDataService.getAllHotels();
		if (response.isEmpty()) {
			return new ResponseEntity<List<HotelData>>(response, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<HotelData>>(response, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelData> update(@RequestBody HotelData hotelData) throws UnsupportedEncodingException {
		HotelData response = null;

		response = hotelDataService.updateHotel(hotelData);
		if (response == null) {
			return new ResponseEntity<HotelData>(response, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<HotelData>(response, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{hotelId}")
	public ResponseEntity<String> delete(@PathVariable int hotelId) throws UnsupportedEncodingException {

		String response = hotelDataService.deleteHotel(hotelId);

		if (response != null) {
			return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("No Hotel with the ID " + hotelId, HttpStatus.NOT_FOUND);
		}
	}
}
