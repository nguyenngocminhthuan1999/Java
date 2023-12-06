package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Book;

public class BookModel {
	List<Book> books;

//find all book
	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from book");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

// find one book
	public Book find(int id) {
		Book book = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			book = null;
		} finally {
			ConnectDB.disconnect();
		}
		return book;
	}

	// creat a book
	public boolean create(Book book) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into book(call_number, isbn, title, author_name, book_fee, issue_status, display, ddc_id) values (?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, book.getCall_number());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setString(4, book.getAuthor_name());
			preparedStatement.setDouble(5, book.getBook_fee());
			preparedStatement.setBoolean(6, book.isIssue_status());
			preparedStatement.setBoolean(7, book.isDisplay());
			preparedStatement.setInt(8, book.getDdc_id());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

//update a book
	public boolean edit(Book book) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update book set call_number = ?, isbn = ?, title = ?, author_name = ?, book_fee = ?, issue_status = ?, display = ?, ddc_id = ? where id = ?");
			preparedStatement.setString(1, book.getCall_number());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setString(4, book.getAuthor_name());
			preparedStatement.setDouble(5, book.getBook_fee());
			preparedStatement.setBoolean(6, book.isIssue_status());
			preparedStatement.setBoolean(7, book.isDisplay());
			preparedStatement.setInt(8, book.getDdc_id());
			preparedStatement.setInt(9, book.getId());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	// delete a book
	public boolean delete(Book book) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update book set display = ? where id = ?");
			preparedStatement.setBoolean(1, book.isDisplay());
			preparedStatement.setInt(2, book.getId());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
//Search by ISBN
	public List<Book> searchByISBN(String keyword) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where isbn like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));

				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

	
	// Search by title
	public List<Book> searchByTitle(String keyword) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where title like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));

				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

//search by author
	public List<Book> searchByAuthor(String keyword) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where author_name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));

				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

	// sort by title ASC
	public List<Book> sortByTitleASC() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book order by title ASC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	// sort by title DESC

	public List<Book> sortByTitleDESC() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book order by title DESC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

	// Sort By Author ASC
	public List<Book> sortByAuthorASC() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book order by author_name ASC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}

	// Sort By Author DESC
	public List<Book> sortByAuthorDESC() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book order by author_name DESC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	
	public Book findISBN(String keyword) {
		Book book = new Book();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where isbn like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setBook_fee(resultSet.getDouble("book_fee"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			book = null;
		} finally {
			ConnectDB.disconnect();
		}
		return book;
	}
	
	public boolean update_status(boolean issue_status,int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update book set issue_status = ? where id = ?");
			preparedStatement.setBoolean(1, issue_status);
			preparedStatement.setInt(2, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Book> find(String keyword) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from book where isbn like ? or title like ? or author_name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor_name(resultSet.getString("author_name"));
				book.setIssue_status(resultSet.getBoolean("issue_status"));
				book.setDisplay(resultSet.getBoolean("display"));
				book.setDdc_id(resultSet.getInt("ddc_id"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		} finally {
			ConnectDB.disconnect();
		}
		return books;
	}
}
