package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Department;
import entities.Employee;

public class EmployeeModels {
	List<Employee> employees;
	private String departmentid;
	public boolean create(Employee employee) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into employee(name, address, phonenumber, departmentid) values(?,?,?,?)");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setString(3, employee.getPhonenumber());
			preparedStatement.setInt(4, employee.getDepartmentid());
			
			
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Employee employee) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("update employee set name = ? , address = ?, phonenumber = ?, departmentid = ? where id = ?");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setString(3, employee.getPhonenumber());
			preparedStatement.setInt(4, employee.getDepartmentid());
			preparedStatement.setInt(5, employee.getId());
			
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public Employee find(int id) {
		Employee employee = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from employee where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
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
	
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from employee ");			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("Id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhonenumber(resultSet.getString("phonenumber"));
				employee.setDepartmentid(resultSet.getInt("departmentid"));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			employees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}
	public List<Employee> findOfEmployee(String departmentid) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from employee where departmentid");
			preparedStatement.setString(1, departmentid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("Id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhonenumber(resultSet.getString("phonenumber"));
				employee.setDepartmentid(resultSet.getInt("departmentid"));
				employees.add(employee);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}
	
	

	public List<Employee> searchByKeyword(String keyword) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from employee where name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("Id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhonenumber(resultSet.getString("phonenumber"));
				employee.setDepartmentid(resultSet.getInt("departmentid"));
				employees.add(employee);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}
	public int findId(String Name) {
		int id = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from employee where name = ?");
			preparedStatement.setString(1, Name);
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
	
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("delete from employee where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}
