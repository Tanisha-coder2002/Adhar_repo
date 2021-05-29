package com.adharcentre.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.adharcentre.connection.DBConnection;

public class AdharDeletionService {
	private static String firstName;
	private static String lastName;
	private static int pincode;
	
	public  void deleteInformation(Scanner input) throws SQLException {
		
		System.out.println("fill the information");
		System.out.println("First name - ");
		System.out.println("Last name - ");
		System.out.println("pincode - ");
		int count =  getQuery1(input);
		System.out.println("there are" + count + "entires");
		System.out.println("is this entries deleted ? ");
		System.out.println("1. yes");
		System.out.println("2 . no");
		int num = input.nextInt();
		if(num == 1) {
			 getQuery2();
			 System.out.println(count + " records deleted");
		}
		else {
			System.out.println("there is no deletion");
		}
		
		
		
	}
	public  String getQuery(int num) {
		switch(num) {
		case 1:{
			return "delete  from personInformation where firstname = ? and lastname = ? and pincode = ?";
		}
		case 2:{
			return "none of the information is deleted";
		}
		case 3:{
			return "select count(*) from personInformation where firstname = ? and lastname = ? and pincode = ?";
		}
		}
		return null;
		
		
	}
	public  int getQuery1(Scanner input) throws SQLException {
		input.nextLine();
		String firstName = input.nextLine();
		String lastName = input.nextLine();
		int Pincode = input.nextInt();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pincode = Pincode;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(getQuery(3));
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setInt(3, Pincode);
		ResultSet set = stmt.executeQuery();
		if(set.next()) {
		return set.getInt(1);
		}
		else {
			return 0;
		}
	}
	public  void getQuery2() throws SQLException {
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(getQuery(1));
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setInt(3, pincode);
	    stmt.executeUpdate();
	   
		
		
		
	
		
	}

	

}
