package com.botree.business;

import com.botree.bean.HmsUser;
import com.botree.dao.HmsLoginDao;
import com.botree.exception.InvalidHmsUserException;

public class HmsLoginBo {
	public boolean validateUser(HmsUser user) throws InvalidHmsUserException {

		var loginDao = new HmsLoginDao();

		loginDao.getUser(user);

		HmsUser u = loginDao.getUser(user);

		if (u != null && u.username().equals(user.username()) && u.password().equals(user.password())) {
			return true;
		}
		throw new InvalidHmsUserException("Invalid username or password");
	}
}
