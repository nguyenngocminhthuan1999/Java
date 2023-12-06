package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.DDC;

public class DDCModel {
// show all ddc
	public List<DDC> findAll() {
		List<DDC> ddcs = new ArrayList<DDC>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from ddc");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DDC ddc = new DDC();
				ddc.setId(resultSet.getInt("id"));
				ddc.setGroup_name(resultSet.getString("group_name"));
				ddc.setNumeric_code(resultSet.getString("numeric_code"));
				ddcs.add(ddc);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			ddcs = null;
		} finally {
			ConnectDB.disconnect();
		}
		return ddcs;
	}

	// create ddc
	public boolean create(DDC ddc) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into ddc(numeric_code, group_name) values(?,?)");
			preparedStatement.setString(1, ddc.getNumeric_code());
			preparedStatement.setString(2, ddc.getGroup_name());

			result = preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

//delete ddc
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from ddc where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	// find one ddc
	public DDC find(int id) {
		DDC ddc = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from ddc where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ddc = new DDC();
				ddc.setId(resultSet.getInt("id"));
				ddc.setGroup_name(resultSet.getString("group_name"));
				ddc.setNumeric_code(resultSet.getString("numeric_code"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			ddc = null;
		} finally {
			ConnectDB.disconnect();
		}
		return ddc;
	}

	// update a ddc
	public boolean edit(DDC ddc) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update ddc set numeric_code = ?, group_name = ? where id = ?");
			preparedStatement.setString(1, ddc.getNumeric_code());
			preparedStatement.setString(2, ddc.getGroup_name());

			preparedStatement.setInt(3, ddc.getId());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}
