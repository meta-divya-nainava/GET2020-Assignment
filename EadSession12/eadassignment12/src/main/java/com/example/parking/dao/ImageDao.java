package com.example.parking.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.model.ImageClass;

public interface ImageDao extends CrudRepository<ImageClass,Integer> {

}
