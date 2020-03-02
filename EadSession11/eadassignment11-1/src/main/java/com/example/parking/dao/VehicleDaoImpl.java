package com.example.parking.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import java.awt.List;
import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.parking.mapper.VehicleMapper;
import com.example.parking.model.EmployeeClass;
import com.example.parking.model.VehicleClass;
import com.example.parking.model.PlanClass;
import com.mysql.cj.Query;
@Component
public class VehicleDaoImpl implements VehicleDaoInterface{
	@Autowired
	private EntityManager entityManager;
	private final String SQL_SELECT_VEHICLE="from VehicleClass where empId=:empId";
	private final String SQL_SELECT_PLAN=" from PlanClass where vehicleType=:vehicleType";
	private final String SQL_SELECT_VEHICLE_TYPE="select vehicleType from VehicleClass where empId=:empId";
	private final String SQL_UPDATE_VEHICLE_PLAN="update VehicleClass set price=:price, plan=:plan where empId=:empId";
	@Override
	public int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(vehicleObject);
		return 1;
	}
	public PlanClass selectPlan(String type) throws ClassNotFoundException, SQLException
	{ 
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query=currentSession.createQuery(SQL_SELECT_PLAN);
		query.setParameter("vehicleType",type.toLowerCase());
		PlanClass planClass = (PlanClass)query.uniqueResult();
		return planClass;		
	
		
	}
	public int updatePlan(String passChoice,HttpSession sessionServlet) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		String SQL_SELECT_VEHICLE_PLAN="select "+passChoice.toLowerCase()+"Price from PlanClass where vehicleType=:vehicleType";
		org.hibernate.query.Query query=currentSession.createQuery(SQL_SELECT_VEHICLE_TYPE);
		query.setParameter("empId", sessionServlet.getAttribute("empId"));
		String vehicleType=((String) query.uniqueResult());
		query=currentSession.createQuery(SQL_SELECT_VEHICLE_PLAN);
		query.setParameter("vehicleType", vehicleType);
		int price=Integer.parseInt((String) query.uniqueResult());
		query=currentSession.createQuery(SQL_UPDATE_VEHICLE_PLAN);
		query.setParameter("price", price);
		query.setParameter("plan", passChoice);
		query.setParameter("empId", sessionServlet.getAttribute("empId"));
		query.executeUpdate();
		return 1;
		
	}
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query=currentSession.createQuery(SQL_SELECT_VEHICLE);
		query.setParameter("empId", empId);
		VehicleClass vehicleObject=(VehicleClass)query.uniqueResult();
		return vehicleObject;
	}
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException
	{

		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query=currentSession.createQuery(SQL_SELECT_VEHICLE);
		query.setParameter("empId", empId);
		if(query.list().size()>0)
		{
			currentSession.close();
			return true;
		}
		else
		{
			currentSession.close();
			return false;
		}
		
		
	}
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate((vehicleObject));
		return 1;
	}
}
