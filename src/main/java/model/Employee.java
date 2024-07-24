package model;

public class Employee {

	private int id;
	private String name;
	private String birthdate;
	private String address;
	private String gender;
	private String phone;
	private String position;
	public Employee(int id, String name, String birthdate, String address, String gender, String phone,
			String position) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.position = position;
	}
	public Employee(String name, String birthdate, String address, String gender, String phone, String position) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
