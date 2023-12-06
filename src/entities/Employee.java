package entities;

public class Employee {
	private int id;
	private String name;
	private String address;
	private String phonenumber;
	private int departmentid;
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name, String address, String phonenumber,  int departmentid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.departmentid = departmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
