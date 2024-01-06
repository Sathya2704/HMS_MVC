package com.botree.business;

import java.util.List;

import com.botree.bean.Doctor;
import com.botree.dao.DoctorDao;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;

public class DoctorBo {

	DoctorDao dDao = new DoctorDao();

	public boolean registerDoctor(Doctor d) throws DuplicateIdException {

		return dDao.addDoctor(d);
	}

	public Doctor findSpecialization(int specialization_id) throws IdNotFoundException {

		return dDao.findSpecialization(specialization_id);
	}

	public List<Doctor> showAllDoctors() {

		return dDao.showAllDoctor();

	}


}
