package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Department;

public class DepartmentModels {
	public List<Department> findAll() {
		List<Department> departments = new ArrayList<Department>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from department");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("id"));
				department.setName_department(resultSet.getString("name_department"));
				departments.add(department);
			}
		} catch (Exception e) {
			e.printStackTrace();
			departments = null;
		} finally {
			ConnectDB.disconnect();
		}
		return departments;
	}
	
	public String find(int id) {
		String name_department = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from department where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name_department = resultSet.getString("name_department");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			name_department = null;
		} finally {
			ConnectDB.disconnect();
		}
		return name_department;
	}

	public int findId(String name_department) {
		int id = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from department where name_department = ?");
			preparedStatement.setString(1, name_department);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			id = 0;
		} finally {
			ConnectDB.disconnect();
		}
		return id;
	}

}
