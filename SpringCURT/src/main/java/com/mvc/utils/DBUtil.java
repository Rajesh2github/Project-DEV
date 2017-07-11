package com.mvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DBUtil {
	@Autowired
	DBValues dBValues;
	
	
	public  Connection getConnection()
	{
		Connection con=null;
		
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishekdb", "root", "rajesh");
		}*/
		try{
			Class.forName(dBValues.getDriver());
			con=DriverManager.getConnection(dBValues.getUrl(), dBValues.getUser(), dBValues.getPassword());
		}
		catch(ClassNotFoundException s)
		{
			System.out.println("exception"+s);
		}
		catch(SQLException sq)
		{
			
		}
		return con;
				
	}


}
