package com.mvc.userRespositroyImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.model.UserCredentials;
import com.mvc.userRespositroy.Authenticat;
import com.mvc.utils.DBUtil;
import com.mvc.utils.SqlQuerys;

@Repository
public class AuthenticatImpl implements Authenticat{

	@Autowired
	DBUtil dBUtil;
	@Autowired
	SqlQuerys sqlQuerys; 
	public boolean userAuthenticat(UserCredentials userCredentials) {
		
		
		Connection con = dBUtil.getConnection();
		boolean check =false;
		try {
			PreparedStatement pr = con.prepareStatement(sqlQuerys.getUserLogin());
			pr.setString(1, userCredentials.getUserId());
			pr.setString(2, userCredentials.getPassword());
			
			ResultSet rs=pr.executeQuery();
			
			if(rs.next())
			{
				check=true;
			}
			else {
				check=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return check;
	
	}
	
	

}
