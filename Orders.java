package daniel_gerbi_natanel_michel7;


public class Orders implements Cloneable {

	private Customer customer;
	private int amount;
	private Products product;
	private String orderId;
	private shippingType shippingType;

	public Orders(Customer customer, int amount, Products product, shippingType shippingType, String orderId) {
		this.customer = customer;
		this.amount = amount;
		this.product = product;
		this.orderId = orderId;
		this.shippingType = shippingType;
	}
	
	public Orders(Customer customer, int amount, Products product,String orderId) {
		this.customer = customer;
		this.amount = amount;
		this.product = product;
		this.orderId = orderId;
	}
	
	
	public void setShippingType(shippingType shippingType) {
		this.shippingType = shippingType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public shippingType getShippingType() {
		return this.shippingType;
	}

	public Orders clone() {
		try {
			return (Orders) super.clone();
		
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(); 
		}
	}

	
}
