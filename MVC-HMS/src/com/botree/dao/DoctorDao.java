package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.bean.Doctor;
import com.botree.bean.Patient;
import com.botree.constants.HmsQueryConstants;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.util.HmsUtil;

public class DoctorDao {

public boolean addDoctor(Doctor d) throws DuplicateIdException{
		
		Connection conn = HmsUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		      pstmt=conn.prepareStatement(HmsQueryConstants.INSERT_D_SQL);
		      pstmt.setInt(1, d.DoctorID());
		      pstmt.setString(2, d.DoctorName());
		      pstmt.setInt(3, d.Specialization_id());
		     
		      pstmt.execute();
		      
		      return true;
		      
		}catch(Exception e) {
			e.printStackTrace();
			throw new DuplicateIdException(d.DoctorID()+"already exist");
		}
	}
	
	
	public Doctor findSpecialization(int Specialization_id) throws IdNotFoundException {
		
	    Connection conn = HmsUtil.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        pstmt = conn.prepareStatement(HmsQueryConstants.SELECT_Spl_SQL);
	        pstmt.setInt(1, Specialization_id);
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) 
	        	
	            return new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"), rs.getInt("Specialization_id"));
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
        throw new IdNotFoundException(Specialization_id+" not found");

	}
	
	
	public List<Doctor> showAllDoctor()  {
		List<Doctor> dList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = HmsUtil.getConnection();
        try {
        pstmt = conn.prepareStatement(HmsQueryConstants.SELECT_D_SQL);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Doctor d = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"), rs.getInt("Specialization_id"));
            dList.add(d);
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }

        return dList;
    }


	public List<Patient> showAllPatient() {
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
