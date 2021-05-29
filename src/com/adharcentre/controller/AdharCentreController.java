package com.adharcentre.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adharcentre.pojo.Person;
import com.adharcentre.service.AdharDeletionService;
import com.adharcentre.service.AdharService;
import com.adharcentre.service.AdharUserService;

public class AdharCentreController {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("please select the below options");
		System.out.println("1. Insert");
		System.out.println("2. Search");
		System.out.println("3. Delete");
		int number = input.nextInt();
		if (number == 1) {
			insertPerson(input);
		} else if (number == 2) {
			search(input);
		}
		else if(number == 3){
			AdharDeletionService service = new AdharDeletionService();
			service.deleteInformation(input);
		}

		input.close();
	}

	private static void insertPerson(Scanner input) throws SQLException {
		int length = input.nextInt();
		input.nextLine();
		List<Person> list = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			Person person = new Person();
			person.setFirstName(input.nextLine());
			person.setMiddleName(input.nextLine());
			person.setLastName(input.nextLine());
			person.setAddress(input.nextLine());
			person.setCountry(input.nextLine());
			// person.setId(input.nextInt());
			person.setPincode(input.nextInt());
			input.nextLine();
			person.setState(input.nextLine());
			list.add(person);
		}
		AdharService adharService = new AdharService();
		int personsCount = adharService.insertPerson(list);
		System.out.println(personsCount + " people has been inserted");

	}

	private static void search(Scanner input) throws SQLException {
		AdharUserService service = new AdharUserService();
		List<Person> data = service.searchInformation(input);
		if(data!=null && data.size()>0) {
		for (Person data1 : data) {
			System.out.println("Address - " + data1.getAddress());
			System.out.println("country - " + data1.getCountry());
			System.out.println("FirstName - " + data1.getFirstName());
			System.out.println("LastName - " + data1.getLastName());
			System.out.println("MiddleName - " + data1.getMiddleName());
			System.out.println("Pincode - " + data1.getPincode());
			System.out.println("State- " + data1.getState());
			//System.out.println(data1.getAddress() + "|" + data1.getCountry() + "|" + data1.getFirstName() + " |"
				//	+ data1.getLastName() + "|" + data1.getMiddleName() + "|" + data1.getPincode());
		}
		}

	}
	

}
