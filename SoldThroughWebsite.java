

package daniel_gerbi_natanel_michel7;

public class SoldThroughWebsite extends Products {
	private String dest_country;

	public SoldThroughWebsite(String product_name, int cost_price, int selling_price, int stock,
			String dest_country,String serialId,double weight) {
		super(product_name, cost_price, selling_price, stock,serialId,weight);
		this.dest_country = dest_country;
	}

	public String getDest_country() {
		return dest_country;
	}

	public void setDest_country(String dest_country) {
		this.dest_country = dest_country;
	}
}

