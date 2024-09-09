package daniel_gerbi_natanel_michel7;

public class FedEx extends Shipping {
	private static final double EXPRESS_PER_10KG = 50.0;
	private static final double EXPRESS_TAX = 20.0;
	private static final double STANDARD_PER_10KG = 10.0;

	public FedEx(String contactPerson, String contactNumber) {
		super(contactPerson, contactNumber, "FedEx");
	}

	@Override
	public double calculateShippingFee(Orders order) {
		double weight = order.getProduct().getWeight();
		double amount = order.getAmount();
		double cost;
		if (order.getShippingType().equals("EXPRESS")) {
			cost = Math.ceil((weight * amount) / 10.0) * EXPRESS_PER_10KG + EXPRESS_TAX;
		} else { 
			cost = Math.ceil((weight * amount) / 10.0) * STANDARD_PER_10KG;
		}
		return cost;
	}

}