package com.example.HotelData.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.HotelData.model.HotelData;


@Repository
public interface HotelDataRespository extends MongoRepository<HotelData, Integer>{

}
