package daniel_gerbi_natanel_michel7;

public class FactorySoldInStore {
	public Products createProduct(String productName, int costPrice, int sellingPrice, int stock, String serialId,double weight) {
		return new SoldInStore(productName, costPrice, sellingPrice, stock, serialId,weight);
	}
}
