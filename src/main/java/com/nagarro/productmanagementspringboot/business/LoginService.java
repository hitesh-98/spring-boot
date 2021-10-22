package com.nagarro.productmanagementspringboot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.productmanagementspringboot.dao.LoginDao;
import com.nagarro.productmanagementspringboot.models.LoginForm;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public boolean validateUser(LoginForm user) {
		return this.loginDao.validateUser(user);
	}

}
