package com.adharcentre.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.adharcentre.connection.DBConnection;
import com.adharcentre.pojo.Person;

public class AdharService {
	public int insertPerson(List<Person> list) throws SQLException {

		int result = 0;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt = con.prepareStatement(
				"insert into personInformation (firstName,middleName,lastName, state,address, country, pincode) values(?,?,?,?,?,?,?)");
		for (Person person : list) {
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getMiddleName());
			stmt.setString(3, person.getLastName());
			stmt.setString(4, person.getState());
			stmt.setString(5, person.getAddress());
			stmt.setString(6, person.getCountry());
			stmt.setInt(7, person.getPincode());
			int record = stmt.executeUpdate();
			result += record;
		}
		return result;
	}

}
