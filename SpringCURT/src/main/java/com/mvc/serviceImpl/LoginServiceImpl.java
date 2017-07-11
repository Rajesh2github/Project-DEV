package com.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.UserCredentials;
import com.mvc.service.LoginService;
import com.mvc.userRespositroy.Authenticat;

@Service
public class LoginServiceImpl implements LoginService {
	
@Autowired
Authenticat authenticat ;
	public boolean userAuthentication( UserCredentials userCredentials){
		
		if(authenticat.userAuthenticat(userCredentials)){
			return true;
		}
	return false;
	}
	
}
