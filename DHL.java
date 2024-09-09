package daniel_gerbi_natanel_michel7;

public class DHL extends Shipping {
	private static final double EXPRESS_FEE = 100.0;
	private static final double EXPRESS_TAX = 20.0;
	private static final double STANDARD_PERCENTAGE = 0.10;
	private static final double STANDARD_MAX_FEE = 100.0;

	public DHL(String contactPerson, String contactNumber) {
		super(contactPerson, contactNumber, "DHL");
	}

	@Override
	public double calculateShippingFee(Orders order) {
		double cost;
		if (order.getShippingType().equals("EXPRESS")) {
			cost = EXPRESS_FEE + EXPRESS_TAX;
		} else {
			double priceBasedFee = (order.getProduct().getSellingPrice() * order.getAmount()) * STANDARD_PERCENTAGE;
			cost = Math.min(priceBasedFee, STANDARD_MAX_FEE);
		}
		return cost;
	}
}
