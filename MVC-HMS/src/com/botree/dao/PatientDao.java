package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.bean.Patient;
import com.botree.constants.HmsQueryConstants;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.util.HmsUtil;


public class PatientDao {

public boolean addPatient(Patient p) throws DuplicateIdException{
		
		Connection conn = HmsUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		      pstmt=conn.prepareStatement(HmsQueryConstants.INSERT_P_SQL);
		      pstmt.setInt(1, p.PatientID());
		      pstmt.setString(2, p.PatientName());
		      pstmt.setInt(3, p.DoctorID());
		     
		      pstmt.execute();
		      
		      return true;
		      
		}catch(Exception e) {
			e.printStackTrace();
			throw new DuplicateIdException(p.PatientID()+"already exist");
		}
	}
	
	
	public List<Patient> showAllPatient()  {
		List<Patient> pList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = HmsUtil.getConnection();
        try {
        pstmt = conn.prepareStatement(HmsQueryConstants.SELECT_P_SQL);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Patient p = new Patient(rs.getInt("PatientID"), rs.getString("PatientName"), rs.getInt("DoctorID"));
            pList.add(p);
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }

        return pList;
    }
	
	
	
}
