package daniel_gerbi_natanel_michel7;

public class ShippingDetails {
	
	private String shippingCompany;
	private double shippingFee;
	private shippingType shippingType;

	public ShippingDetails(String shippingCompany, double shippingFee, shippingType shippingType) {
		this.shippingCompany = shippingCompany;
		this.shippingFee = shippingFee;
		this.shippingType = shippingType;
	}

	public String getShippingCompany() {
		return shippingCompany;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public shippingType getShippingType() {
		return shippingType;
	}
}
