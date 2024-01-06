package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.bean.Specialization;
import com.botree.constants.HmsQueryConstants;
import com.botree.util.HmsUtil;

public class SpecializationDao {
	public List<Specialization> show_specialization() {
		List<Specialization> speclist=new ArrayList<>();
	     Connection conn=HmsUtil.getConnection();
	     PreparedStatement pstmt=null;
	     ResultSet rs=null;
	    try {
		pstmt=conn.prepareStatement(HmsQueryConstants.SEARCH_SPL_SQL);
		rs=pstmt.executeQuery();
	   while(rs.next()) {
			Specialization specialization= new Specialization(rs.getInt("sid"),rs.getString("sname"));
     speclist.add(specialization);
		}
	}catch(Exception e) {
		
	}
	    return speclist;
		}
		
}
