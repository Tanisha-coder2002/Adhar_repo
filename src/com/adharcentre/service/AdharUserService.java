package com.adharcentre.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adharcentre.connection.DBConnection;
import com.adharcentre.pojo.Person;

public class AdharUserService {
	
	public List<Person> searchInformation(Scanner input) throws SQLException{
		
		System.out.println("choose the information");
		System.out.println("1. State of the person");
		System.out.println("2. firstName of the person");
		System.out.println("3. pincode of the person");
		System.out.println("4. address of the person");
		System.out.println("5. country of the person");
		int num = input.nextInt();
		if(num == 1) {
			return getInformation(input);
		}
		else if(num == 2) {
			return getInformation1(input);
		}
		else if(num == 3) {
			return getInformation2(input);
		}
		else {
			System.out.println("currently this is not available");
		}
		
		return null;
		
	}
	public static String getQuery(int num) {
		switch(num) {
		case 1:{
			return "select * from personInformation where state = ?";
		}
		case 2:{
			return "select * from personInformation where firstName = ?";
		}
		case 3:{
			return "select * from personInformation where pincode = ?";
		}
	}
		return null;
	}
	public List<Person> getInformation(Scanner input) throws SQLException{
		input.nextLine();
		System.out.println("enter state-");
		String state = input.nextLine();
		List<Person> list = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(getQuery(1));
		stmt.setString(1,state);
		ResultSet set = stmt.executeQuery();
		while(set.next()) {
			Person person = new Person();
			person.setAddress(set.getString("Address"));
			person.setCountry(set.getString("country"));
			person.setFirstName(set.getString("firstName"));
			person.setLastName(set.getString("LastName"));
			person.setMiddleName(set.getString("MiddleName"));
			person.setPincode(set.getInt("pincode"));
			list.add(person);
		}
		return list;
	}
	public List<Person> getInformation1(Scanner input) throws SQLException{
		input.nextLine();
	System.out.println("enter firstName -");
		String firstName = input.nextLine();
		List<Person> list1 = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(getQuery(2));
		stmt.setString(1, firstName);
		ResultSet set1 = stmt.executeQuery();
		while(set1.next()) {
			Person person = new Person();
			person.setAddress(set1.getString("Address"));
			person.setCountry(set1.getString("country"));
			person.setLastName(set1.getString("LastName"));
			person.setMiddleName(set1.getString("MiddleName"));
			person.setPincode(set1.getInt("pincode"));
			person.setState(set1.getString("State"));
			list1.add(person);
		}
		return list1;
		}
	
	public List<Person> getInformation2(Scanner input) throws SQLException{
		input.nextLine();
	System.out.println("enter Pincode -");
		int pincode = input.nextInt();
		List<Person> list1 = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(getQuery(3));
		stmt.setInt(1, pincode);
		ResultSet set1 = stmt.executeQuery();
		while(set1.next()) {
			Person person = new Person();
			person.setAddress(set1.getString("Address"));
			person.setCountry(set1.getString("country"));
			person.setLastName(set1.getString("LastName"));
			person.setMiddleName(set1.getString("MiddleName"));
			person.setFirstName(set1.getString("firstName"));
			person.setState(set1.getString("State"));
			list1.add(person);
		}
		return list1;
		}
	
		
			
				
	}			
			
			