package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.parking.dao.EmployeeDaoInterface;
import com.example.parking.dao.ImageDao;
import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;
import com.example.parking.model.ImageClass;
@Service
public class EmployeeServiceImlp implements EmployeeServiceInterface {
	@Autowired
	private EmployeeDaoInterface daoObject;
	@Autowired
	private ImageDao imagedao;
	@Override
	@Transactional
	public int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException {
		daoObject.save(employeeObject);
		return 1;
	}
	@Override
	@Transactional
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException
	{
		//create
		return daoObject.getEmployeeId(email);
	}
	@Override
	@Transactional
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.findById(empId).orElse(null);
	}
	@Override
	@Transactional
	public List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException
	{
		List<Object[]> friendList=daoObject.showFriends((int)session.getAttribute("empId"));
		List<FriendClass> friends = new ArrayList<>();
		for (Object[] row : friendList) {
			FriendClass friend = new FriendClass();
			friend.setName((String) row[1]);
			friend.setEmpId((int) row[0]);
			friends.add(friend);			
		}
		return friends;
		
		
	}
	@Override
	@Transactional
	public void setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException
	{
		ImageClass image=new ImageClass();
		image.setEmpId(empId);
		image.setImageName(imageName);
		imagedao.save(image);
		
	}
	@Override
	@Transactional
	public String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException
	{
		ImageClass image=imagedao.findById(empId).orElse(null);
		if(image==null)
		{
			return "profile.png";
		}
		return image.getImageName();
		
		
	}
	@Override
	@Transactional
	public boolean isEmailExist(String email)
	{
		//create
		return daoObject.isEmailExist(email)>0;
	}

}
