package daniel_gerbi_natanel_michel7;

public class Customer {

	private String customerName;
	private String mobile;

	public Customer(String customer_name, String mobile) {
		this.customerName = customer_name;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return  customerName + ", mobile=" + mobile ;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customer_name) {
		this.customerName = customer_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
