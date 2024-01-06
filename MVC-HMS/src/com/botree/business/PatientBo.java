package com.botree.business;

import java.util.List;

import com.botree.bean.Patient;
import com.botree.dao.PatientDao;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;


public class PatientBo {
	
	PatientDao pDao = new PatientDao();

	public boolean registerPatient(Patient p) throws DuplicateIdException {

		return pDao.addPatient(p);
	}

	public List<Patient> showAllPatient() {

		return pDao.showAllPatient();

	}

	
}
