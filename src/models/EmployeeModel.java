package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;;

public class EmployeeModel {
	public Employee findId(int id) {
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from employee where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhonenumber(resultSet.getString("phonenumber"));
				employee.setDepartmentid(resultSet.getInt("departmentid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			employee = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employee;
	}
}
