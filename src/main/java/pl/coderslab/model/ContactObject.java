package pl.coderslab.model;

public class ContactObject {
	
	
	private String name;
	private String email;
	private String address;
	private int phoneNumber;
	private String description;
	
	public ContactObject () {
	
	}
	
	public String getName () {
		
		return name;
	}
	
	public void setName (String name) {
		
		this.name = name;
	}
	
	public String getEmail () {
		
		return email;
	}
	
	public void setEmail (String email) {
		
		this.email = email;
	}
	
	public String getFacebook () {
		
		return address;
	}
	
	public void setAddress (String facebook) {
		
		this.address = facebook;
	}
	
	public int getPhoneNumber () {
		
		return phoneNumber;
	}
	
	public void setPhoneNumber (int phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}
	
	public String getDescription () {
		
		return description;
	}
	
	public void setDescription (String description) {
		
		this.description = description;
	}
}

