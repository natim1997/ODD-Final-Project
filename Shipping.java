package daniel_gerbi_natanel_michel7;


public abstract class Shipping {
	
	private String contact;
	private String phoneNumber;
	private String name;
	
	public Shipping(String contact, String phoneNumber, String name) {
		this.contact = contact;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	public abstract double calculateShippingFee(Orders order);

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
