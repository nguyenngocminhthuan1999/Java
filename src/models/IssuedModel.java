package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Issued;

public class IssuedModel {
	public List<Issued> findAll() {
		List<Issued> issueds = new ArrayList<Issued>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from issued");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Issued issued = new Issued();
				issued.setId(resultSet.getInt("id"));
				issueds.add(issued);
			}
		} catch (Exception e) {
			e.printStackTrace();
			issueds = null;
		} finally {
			ConnectDB.disconnect();
		}
		return issueds;
	}

	public List<Issued> findIssued_Idbook(int id_book) {
		List<Issued> issueds = new ArrayList<Issued>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from issued where id_book = ? ORDER BY return_date DESC");
			preparedStatement.setInt(1, id_book);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Issued issued = new Issued();
				issued.setId(resultSet.getInt("id"));
				issued.setIssue_date(resultSet.getDate("issue_date"));
				issued.setReturn_date(resultSet.getDate("return_date"));
				issued.setId_employee(resultSet.getInt("id_employee"));
				issued.setId_book(resultSet.getInt("id_book"));
				;
				issued.setStatus(resultSet.getBoolean("status"));
				issueds.add(issued);
			}
		} catch (Exception e) {
			e.printStackTrace();
			issueds = null;
		} finally {
			ConnectDB.disconnect();
		}
		return issueds;
	}

	public boolean create(int id_employee, int id_book, boolean status) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into issued(id_employee, id_book, status) values(?,?,?)");
			preparedStatement.setInt(1, id_employee);
			preparedStatement.setInt(2, id_book);
			preparedStatement.setBoolean(3, status);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Issued> findIssued_Idemployee(int id_employee) {
		List<Issued> issueds = new ArrayList<Issued>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from issued where id_employee = ? AND status = ? ORDER BY issue_date DESC");
			preparedStatement.setInt(1, id_employee);
			preparedStatement.setBoolean(2, false);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Issued issued = new Issued();
				issued.setId(resultSet.getInt("id"));
				issued.setIssue_date(resultSet.getDate("issue_date"));
				issued.setReturn_date(resultSet.getDate("return_date"));
				issued.setId_employee(resultSet.getInt("id_employee"));
				issued.setId_book(resultSet.getInt("id_book"));
				;
				issued.setStatus(resultSet.getBoolean("status"));
				issueds.add(issued);
			}
		} catch (Exception e) {
			e.printStackTrace();
			issueds = null;
		} finally {
			ConnectDB.disconnect();
		}
		return issueds;
	}
	
	public Issued findIssued_Idbook_Idemployee_Status(int id_book, int id_employee) {
		Issued issued = new Issued();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from issued where id_book = ? AND status = ?");
//			.prepareStatement("select * from issued where id_book = ? AND id_employee = ? AND status = ?");
			preparedStatement.setInt(1, id_book);
//			preparedStatement.setInt(2, id_employee);
			preparedStatement.setBoolean(2, false);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				issued.setId(resultSet.getInt("id"));
				issued.setIssue_date(resultSet.getDate("issue_date"));
				issued.setReturn_date(resultSet.getDate("return_date"));
				issued.setId_employee(resultSet.getInt("id_employee"));
				issued.setId_book(resultSet.getInt("id_book"));
				issued.setStatus(resultSet.getBoolean("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			issued = null;
		} finally {
			ConnectDB.disconnect();
		}
		return issued;
	}
	
	public boolean update_status(boolean status,int id, Date return_date) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update issued set status = ?, return_date = ?  where id = ?");
			preparedStatement.setBoolean(1, status);
			preparedStatement.setDate(2, return_date);
			preparedStatement.setInt(3, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public Issued findID(int id) {
		Issued issued = new Issued();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from issued where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				issued.setId(resultSet.getInt("id"));
				issued.setIssue_date(resultSet.getDate("issue_date"));
				issued.setReturn_date(resultSet.getDate("return_date"));
				issued.setId_employee(resultSet.getInt("id_employee"));
				issued.setId_book(resultSet.getInt("id_book"));
				issued.setStatus(resultSet.getBoolean("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			issued = null;
		} finally {
			ConnectDB.disconnect();
		}
		return issued;
	}
	
	public int CountIssued_Idemployee(int id_employee) {
		int count = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from issued where id_employee = ? AND status = ? ORDER BY issue_date DESC");
			preparedStatement.setInt(1, id_employee);
			preparedStatement.setBoolean(2, false);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			count = 0;
		} finally {
			ConnectDB.disconnect();
		}
		return count;
	}
}
