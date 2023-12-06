package entities;

public class Book {
	private int id;
	private String call_number;
	private String isbn;
	private String title;
	private String author_name;
	private Double book_fee;
	private boolean issue_status;
	private boolean display;
	private int ddc_id;
	public int getDdc_id() {
		return ddc_id;
	}
	public void setDdc_id(int ddc_id) {
		this.ddc_id = ddc_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCall_number() {
		return call_number;
	}
	public void setCall_number(String call_number) {
		this.call_number = call_number;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Double getBook_fee() {
		return book_fee;
	}
	public void setBook_fee(Double book_fee) {
		this.book_fee = book_fee;
	}
	public boolean isIssue_status() {
		return issue_status;
	}
	public void setIssue_status(boolean issue_status) {
		this.issue_status = issue_status;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	
}
