package com.botree.controller;

import java.util.List;
import java.util.Scanner;

import com.botree.bean.Doctor;
import com.botree.bean.HmsUser;
import com.botree.bean.Patient;
import com.botree.bean.Specialization;
import com.botree.business.DoctorBo;
import com.botree.business.HmsLoginBo;
import com.botree.business.PatientBo;
import com.botree.business.SpecializationBo;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.exception.InvalidHmsUserException;

public class HmsMain {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag=true;
		
		do {
			var user = login();
			
			var LoginBo = new HmsLoginBo();
			
			try {
				flag = !LoginBo.validateUser(user);
			}catch(InvalidHmsUserException e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		do {
			System.out.println("Select option");
			
			System.out.println("""
					1. Register Doctor \n 
					2. Register Patient \n 
					3. Find by Doctor Specialization \n 
					4. Show All Doctor \n
					5. Show All Patient \n
					6. Exit 
					""");
            int option = sc.nextInt();
			
			switch(option) {
			case 1 -> registerDoctor();
			
			case 2 -> registerPatient();
			
			case 3 -> findSpecialization();

			case 4 -> showAllDoctor();
			
			case 5 -> showAllPatient();
			
			case 6 -> System.exit(0);

			default -> System.out.println("Wrong Choice");
			}	
		}while(true);
	}
	
	public static void registerDoctor() {

		System.err.println("Register Page");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Doctor ID : ");
		int DoctorID = sc.nextInt();

		System.out.println("Enter Doctor Name : ");
		String DoctorName = sc.next();

		var specializationBo=new SpecializationBo();

		 List<Specialization> specList = specializationBo.show_specialization();
		 
	     for (Specialization s : specList) {
		        System.out.println("ID: " + s.Specialization_id() + ", Name: " + s.Specialization_Name() );
		    }
		
		System.out.println("Enter Specialization ID : ");
		int Specialization_id = sc.nextInt();
		
		var d = new Doctor(DoctorID, DoctorName, Specialization_id);

		var dBo = new DoctorBo();

		try {
			dBo.registerDoctor(d);
			System.out.println(DoctorID + "registered successfully");

		} catch (DuplicateIdException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void registerPatient() {

		System.err.println("Register Page");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Patient ID : ");
		int PatientID = sc.nextInt();

		System.out.println("Enter Patient Name : ");
		String PatientName = sc.next();

		System.out.println("Enter Doctor ID : ");
		int DoctorID = sc.nextInt();
		
		var p = new Patient(PatientID, PatientName, DoctorID);

		var pBo = new PatientBo();

		try {
			pBo.registerPatient(p);
			System.out.println(PatientID + "registered successfully");

		} catch (DuplicateIdException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void findSpecialization() {
		System.err.println("Search Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Specialization ID : ");
		int Specialization_id = sc.nextInt();
		
		var dBo = new DoctorBo();
		 List<Doctor> docList2;
		try {
		System.out.println(dBo.findSpecialization(Specialization_id));
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	 public static void showAllDoctor() {
	        System.err.println("Display Page");

	        var dBo = new DoctorBo();
	        List<Doctor> d = dBo.showAllDoctors();

	        if (d.isEmpty()) {
	            System.out.println("No doctor found.");
	        } else {
	            System.out.println("Doctor List:");
	            for (Doctor doctors : d) {
	                System.out.println(doctors);
	            }
	        }
	    }
	 
	 public static void showAllPatient() {
	        System.err.println("Display Page");

	        var pBo = new PatientBo();
	        List<Patient> p = pBo.showAllPatient();

	        if (p.isEmpty()) {
	            System.out.println("No patient found.");
	        } else {
	            System.out.println("Patient List:");
	            for (Patient patients : p) {
	                System.out.println(patients);
	            }
	        }
	    }

	public static HmsUser login() {
		
		System.err.println("Login Page");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name : ");
		String name = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		return new HmsUser(name, password);
		
	}
}
