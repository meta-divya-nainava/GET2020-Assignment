package com.EAD3;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetIntialData {
	public void setSession(HttpServletRequest req,int userId)
	{
		HttpSession session= req.getSession();
		session.setAttribute("userId", userId);
		
	}
	public void removeCache(HttpServletRequest req,HttpServletResponse response) throws IOException
	{
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");
		HttpSession session= req.getSession();
				if (session.getAttribute("userId") == null) {
				response.sendRedirect("login.html");
				return;}
	}
	public void logOut(HttpServletRequest req,HttpServletResponse response) throws IOException
	{
		HttpSession session= req.getSession();
		 session.removeAttribute("userId");
		    response.sendRedirect("login.html");
	}

}
