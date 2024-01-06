package com.botree.business;

import java.util.List;

import com.botree.bean.Specialization;
import com.botree.dao.SpecializationDao;

public class SpecializationBo {
SpecializationDao specdao=new SpecializationDao();
	
	public List<Specialization> show_specialization() {
		return specdao.show_specialization();
	}
}
