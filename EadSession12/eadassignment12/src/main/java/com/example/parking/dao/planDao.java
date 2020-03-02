package com.example.parking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.parking.model.PlanClass;
@Component
public interface planDao extends CrudRepository<PlanClass, String>  {
	

}
