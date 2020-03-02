package com.example.parking.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.parking.mapper.EmployeeMapper;
import com.example.parking.mapper.FriendMapper;
import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;
import com.example.parking.model.ImageClass;
import com.mysql.cj.Query;
import com.mysql.cj.protocol.Resultset;

@Component
public class EmployeeDaoImpl implements EmployeeDaoInterface{
	@Autowired
	private EntityManager entityManager;
	private final String SQL_SELECT_EMPLOYEE =  "from EmployeeClass where empId =:empId";
	private final String SQL_SELECT_EMPLOYEEID="select empId from EmployeeClass where email=:email";
	private final String SQL_UPDATE_EMPLOYEE="update EmployeeClass set name=:name,gender=:gender, email=:email, contactNo=:contact, org=:org where empId=:empId";
	private final String SQL_SELECT_ORG= "select typeOfOrg from EmployeeClass where empId=:empId";
	private final String SQL_SELECT_FRIEND="select empId,name from EmployeeClass where typeOfOrg=:org and empId!=:empId";
	private final String SQL_SELECT_IMAGE="SELECT ImageName FROM ImageClass where empId=:empId";
	private final String SQL_SELECT_IMAGE_EMPID="select empId from ImageClass where empId =:empId";
	private final String SQL_INSERT_IMAGE="insert into image values(?, ?)";
	private final String SQL_UPDATE_IMAGE="update image set imageName =? where empId = ?";
	private final String SQL_EXIST_EMAIL="from EmployeeClass where email=:email";
	
	@Override
	public int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employeeObject);
		System.out.println("grvvvvv");
		return 1;
		}
	@Override
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_SELECT_EMPLOYEEID);
		query.setParameter("email", email);
		return (int)query.uniqueResult();
		
	} 
	@Override
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_SELECT_EMPLOYEE);
		query.setParameter("empId", empId);
		EmployeeClass employeeObject = (EmployeeClass) query.uniqueResult();
		return employeeObject;
		
	}
	@Override
	public int updateEmployee(EmployeeClass employeeObject,HttpSession sessionServlet) throws ClassNotFoundException, SQLException
	{
		
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_UPDATE_EMPLOYEE);
		query.setParameter("name", employeeObject.getName());
		query.setParameter("gender", employeeObject.getGender());
		query.setParameter("email", employeeObject.getGender());
		query.setParameter("contact", employeeObject.getContact());
		query.setParameter("org", employeeObject.getTypeOfOrg());
		query.setParameter("empId", sessionServlet.getAttribute("empId"));
		return 1;
	}
	@Override
	public List<FriendClass> showFriends(HttpSession sessionServlet) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_SELECT_ORG);
		query.setParameter("empId", (int)sessionServlet.getAttribute("empId"));
		String org=(String) query.list().get(0);
		query= currentSession.createQuery(SQL_SELECT_FRIEND);
		query.setParameter("org", org);
		query.setParameter("empId", sessionServlet.getAttribute("empId"));
		List<Object[]> friendsList = query.getResultList();
		List<FriendClass> friends = new ArrayList<>();
		for (Object[] row : friendsList) {
			FriendClass friend = new FriendClass();
			friend.setName((String) row[1]);
			friend.setEmpId((int) row[0]);
			friends.add(friend);			
		}
		
		return friends;
		
	}
	@Override
	public int setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException
	{
		ImageClass image=new ImageClass();
		image.setEmpId(empId);
		image.setImageName(imageName);
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate((image));
		return 1;
		
	}
	@Override
	public String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException {

		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_SELECT_IMAGE_EMPID);
		query.setParameter("empId", empId);
		if(query.list().size()>0)
		{
			query= currentSession.createQuery(SQL_SELECT_IMAGE);
			query.setParameter("empId", empId);
			String imageName=(String)query.uniqueResult();
			return imageName;
		}
		else
		{
			return "profile.png";
		}
		
		
	}
	@Override
	public boolean isEmailExist(String email)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_EXIST_EMAIL);
		query.setParameter("email", email);
		if(query.list().size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
