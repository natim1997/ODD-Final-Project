package daniel_gerbi_natanel_michel7;

import java.util.ArrayList;
import java.util.List;

public class ShippingManager {
	private List<Shipping> shippingCompanies;

	public ShippingManager() {
        this.shippingCompanies = new ArrayList<>();
        }

	public void addShippingCompany(Shipping shipping) {
		shippingCompanies.add(shipping);
	}
	
}
