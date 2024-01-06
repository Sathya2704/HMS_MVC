package com.botree.constants;

public class HmsQueryConstants {

	public static final String LOGIN_SQL = """
			select password from user where username=?
			""";
	//for Patients
	public static final String INSERT_P_SQL="""
			insert into Patient_Master values(?,?,?);
			""";
	
	public static final String SEARCH_P_SQL="""
			select * from Patient_Master where PatientID =?;
			""";
	
	public static final String SELECT_P_SQL="""
			select * from Patient_Master;
			""";
	
	//for Doctors
	public static final String INSERT_D_SQL="""
			insert into Doctor_Master values(?,?,?);
			""";
	
	public static final String SEARCH_D_SQL="""
			select * from Doctor_Master where Specialization =?;
			""";
	
	public static final String SELECT_D_SQL="""
			select * from Doctor_Master;
			""";
	
	public static final String SELECT_Spl_SQL="""
			select Specialization from Doctor_Master;
			""";
	public static final String SEARCH_SPL_SQL="""
			select * from Specialization
			""";
}
